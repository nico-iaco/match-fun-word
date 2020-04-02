package it.iacovelli.matchfunwords.model

import it.iacovelli.matchfunwords.model.dto.PlayerDto
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "matches")
class Match (var active: Boolean, val private: Boolean) {

    @Id
    lateinit var _id: String

    val playerList: MutableSet<PlayerDto> = HashSet()

    val questions: MutableSet<Question> = HashSet()

    val answers: MutableSet<Answer> = HashSet()

    fun addPlayer(player: PlayerDto): Match {
        playerList.add(player)
        return this
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Match

        if (_id != other._id) return false

        return true
    }

    override fun hashCode(): Int {
        return _id.hashCode()
    }


}