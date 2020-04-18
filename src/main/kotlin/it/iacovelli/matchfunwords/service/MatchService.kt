package it.iacovelli.matchfunwords.service

import it.iacovelli.matchfunwords.exception.EmptyListException
import it.iacovelli.matchfunwords.exception.MatchNotFoundException
import it.iacovelli.matchfunwords.model.Answer
import it.iacovelli.matchfunwords.model.Match
import it.iacovelli.matchfunwords.model.Question
import it.iacovelli.matchfunwords.model.dto.PlayerDto
import it.iacovelli.matchfunwords.repository.MatchRepository
import it.iacovelli.matchfunwords.utils.RandomStringUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class MatchService(private val questionService: QuestionService,
                   private val answerService: AnswerService,
                   private val randomStringUtils: RandomStringUtils,
                   private val matchRepository: MatchRepository) {

    private val LOGGER: Logger = LoggerFactory.getLogger(MatchService::class.java)

    /**
     * This method creates a new playable match and add the creator to its player
     * @param playerCreatorId the username of the creator user
     * @return the match code used to invite other player
     */
    fun createMatch(playerCreatorId: String): String {
        val match = Match(active = true, private = true)
        match.id = randomStringUtils.getRandomString(6)
        match.answers.addAll(answerService.getAllAnswer())
        match.questions.addAll(questionService.getAllQuestion())
        val playerDto = PlayerDto(playerCreatorId)
        match.addPlayer(playerDto)
        matchRepository.save(match)
        return match.id
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
            matchRepository.save(m)
        } else {
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
            val wasRemoved = m.playerList.remove(playerDto)
            matchRepository.save(m)
            return wasRemoved
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

    /**
     * This method get an answer card from the match in a synchronous way so that multiple user can't
     * get the same card for the same match
     * @param matchId the id of the match
     * @throws MatchNotFoundException if the match wasn't found
     * @return an answer from the answers available
     */
    @ExperimentalStdlibApi
    @Synchronized
    @Throws(EmptyListException::class)
    fun getAnswerCardFromMatch(matchId: String): Answer {
        val match = matchRepository.findById(matchId).orElseThrow { throw MatchNotFoundException("Nessun match trovato con l'id") }
        val shuffled: MutableList<Answer> = match.answers.shuffled().toMutableList()
        try {
            val answer = shuffled.removeFirst()

            match.answers.remove(answer)
            matchRepository.save(match)

            return answer
        } catch (e: NoSuchElementException) {
            throw EmptyListException("Carte risposta finite");
        }

    }

    /**
     * This method get a question card from the match in a synchronous way so that multiple user can't
     * get the same card for the same match
     * @param matchId the id of the match
     * @throws MatchNotFoundException if the match wasn't found
     * @return a question from the questions available
     */
    @ExperimentalStdlibApi
    @Synchronized
    fun getQuestionCardFromMatch(matchId: String): Question {
        val match = matchRepository.findById(matchId).orElseThrow { throw MatchNotFoundException("Nessun match trovato con l'id") }
        val shuffled: MutableList<Question> = match.questions.shuffled().toMutableList()
        val question = shuffled.removeFirst()

        match.questions.remove(question)
        matchRepository.save(match)

        return question
    }

    @ExperimentalStdlibApi
    fun getAnswerCardsFromMatch(matchId: String, numberOfCards: Int): List<Answer> {
        val answers = ArrayList<Answer>()

        for (i in 1..numberOfCards) {
            try {
                answers.add(getAnswerCardFromMatch(matchId))
            } catch (e: EmptyListException) {
                LOGGER.debug(e.message)
                break
            }

        }

        return answers
    }

    /**
     * This method update the match incrementing the points of the player who had won the last round
     * @param matchId the id of the match
     * @param playerId the username of the player who had won the last round
     */
    fun updateMatchPoints(matchId: String, playerId: String) {
        LOGGER.debug("Updating match: {} for user: {}", matchId, playerId)
        val match = matchRepository.findById(matchId).orElseThrow { throw MatchNotFoundException("Match non trovato") }
        match.playerList.forEach { playerDto: PlayerDto ->
            if (playerDto.playerId == playerId) {
                playerDto.points = playerDto.points + 1
                LOGGER.debug("Now {} has {} points", playerId, playerDto.points)
            }
        }
        matchRepository.save(match)
    }

}