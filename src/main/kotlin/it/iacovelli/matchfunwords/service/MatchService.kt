package it.iacovelli.matchfunwords.service

import it.iacovelli.matchfunwords.exception.MatchNotFoundException
import it.iacovelli.matchfunwords.model.Match
import it.iacovelli.matchfunwords.model.dto.PlayerDto
import it.iacovelli.matchfunwords.repository.MatchRepository
import it.iacovelli.matchfunwords.utils.RandomStringUtils
import org.springframework.stereotype.Service

@Service
class MatchService(private val questionService: QuestionService,
                   private val answerService: AnswerService,
                   private val randomStringUtils: RandomStringUtils,
                   private val matchRepository: MatchRepository) {

    /**
     * This method creates a new playable match and add the creator to its player
     * @param playerCreatorId the username of the creator user
     * @return the match code used to invite other player
     */
    fun createMatch(playerCreatorId: String): String {
        val match = Match(active = true, private = true)
        match._id = randomStringUtils.getRandomString(6)
        match.answers.addAll(answerService.getAllAnswer())
        match.questions.addAll(questionService.getAllQuestion())
        val playerDto = PlayerDto(playerCreatorId)
        match.addPlayer(playerDto)
        matchRepository.save(match)
        return match._id
    }

    /**
     * This method adds the current player to a match
     * @param playerId the username of the user who wants to join the match
     * @param matchId the id of the match to join in
     * @throws MatchNotFoundException if the match wasn't found
     */
    fun partecipateToMatch(playerId: String, matchId: String): Boolean {
        val match = matchRepository.findById(matchId)
        if (match.isPresent) {
            val m = match.get()
            val playerDto = PlayerDto(playerId)
            m.addPlayer(playerDto)
        }else {
            throw MatchNotFoundException("Nessuna partita trovata con quell'id")
        }
        return true
    }

    /**
     * This method removes a player from the match
     * @param playerId the username of the user to remove from the match
     * @param matchId the id of the match from where remove the player
     * @return true if the player is removed, false otherwise
     */
    fun removePlayerFromMatch(playerId: String, matchId: String): Boolean {
        val match = matchRepository.findById(matchId)
        if (match.isPresent) {
            val m = match.get()
            val playerDto = PlayerDto(playerId)
            return m.playerList.remove(playerDto)
        } else {
            throw MatchNotFoundException("Nessuna partita trovata con quell'id")
        }
    }

    /**
     * This method returns all match that have private flag to false
     * @return all public match
     */
    fun getPublicMatches(): List<Match> {
        return matchRepository.findByPrivate(false)
    }

    /**
     * This method set the active flag on match to false
     * @param matchId the id of the match to finish
     * @throws MatchNotFoundException if the match wasn't found
     */
    fun finishMatch(matchId: String) {
        val match = matchRepository.findById(matchId)
        if (match.isPresent) {
            val m = match.get()
            m.active = false
            matchRepository.save(m)
        } else {
            throw MatchNotFoundException("Nessuna partita trovata con quell'id")
        }
    }

}