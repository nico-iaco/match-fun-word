package it.iacovelli.matchfunwords.controller

import it.iacovelli.matchfunwords.exception.EmptyListException
import it.iacovelli.matchfunwords.model.dto.CardDto
import it.iacovelli.matchfunwords.service.MatchService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller

@Controller
class GameController(val matchService: MatchService) {

    private val LOGGER: Logger = LoggerFactory.getLogger(GameController::class.java)

    @Autowired
    private lateinit var simpMessagingTemplate: SimpMessagingTemplate

    @ExperimentalStdlibApi
    @MessageMapping("/match/{matchId}/player/{playerId}/card")
    @SendTo("/game/judge/{matchId}")
    fun sendCardToJudge(@DestinationVariable matchId: String, @DestinationVariable playerId: String, @Payload card: CardDto): CardDto {
        try {
            simpMessagingTemplate.convertAndSend("/game/player/${matchId}/${playerId}", matchService.getAnswerCardFromMatch(matchId))
        } catch (e: EmptyListException) {
            LOGGER.debug(e.message)
        }
        
        LOGGER.debug("Match: {}, Player: {}, Card: {}", matchId, playerId, card)
        return card
    }

    @MessageMapping("/match/{matchId}/judge/choose")
    @SendTo("/game/player/{matchId}")
    fun chooseRoundWinner(@DestinationVariable matchId: String, @Payload card: CardDto): CardDto {
        matchService.updateMatchPoints(matchId, card.playerId)
        LOGGER.debug("Match: {}, Card: {}", matchId, card)
        return card
    }


}