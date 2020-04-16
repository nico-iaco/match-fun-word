package it.iacovelli.matchfunwords.controller

import it.iacovelli.matchfunwords.model.dto.CardDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class GameController {

    private val LOGGER: Logger = LoggerFactory.getLogger(GameController::class.java)

    @MessageMapping("/match/{matchId}/player/{playerId}/card")
    @SendTo("/game/judge/{matchId}")
    fun sendCardToJudge(@DestinationVariable matchId: String, @DestinationVariable playerId: String, @Payload card: CardDto): CardDto {
        //TODO: Inviare al giocatore una nuova carta
        LOGGER.info("Match: {}, Player: {}, Card: {}", matchId, playerId, card)
        return card
    }

    @MessageMapping("/match/{matchId}/judge/choose")
    @SendTo("/game/player/{matchId}")
    fun chooseRoundWinner(@DestinationVariable matchId: String, @Payload card: CardDto): CardDto {
        //TODO: Richiamare metodo per aggiornare il punteggio
        LOGGER.info("Match: {}, Card: {}", matchId, card)
        return card
    }


}