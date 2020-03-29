package it.iacovelli.matchfunwords.model

import it.iacovelli.matchfunwords.model.dto.PlayerDto
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "matches")
class Match (var active: Boolean, val private: Boolean) {

    @Id
    lateinit var id: String

    val playerList: MutableSet<PlayerDto> = HashSet()

    val questions: MutableSet<Question> = HashSet()

    val answers: MutableSet<Answer> = HashSet()

    fun addPlayer(player: PlayerDto): Match {
        playerList.add(player)
        return this
    }



}