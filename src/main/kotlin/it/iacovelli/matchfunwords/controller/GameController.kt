package it.iacovelli.matchfunwords.controller

import it.iacovelli.matchfunwords.model.dto.CardDto
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class GameController {

    @MessageMapping("/match/{matchId}/player/{playerId}/card")
    @SendTo("/game/judge/{matchId}")
    fun sendCardToJudge(@DestinationVariable matchId: String, @DestinationVariable playerId: String, @Payload card: CardDto): CardDto {
        //TODO: Inviare al giocatore una nuova carta
        return card
    }

    @MessageMapping("/match/{matchId}/judge/choose")
    @SendTo("/game/player/{matchId}")
    fun chooseRoundWinner(@DestinationVariable matchId: String, @Payload card: CardDto): CardDto {
        //TODO: Richiamare metodo per aggiornare il punteggio
        return card
    }


}