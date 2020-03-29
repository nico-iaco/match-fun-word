package it.iacovelli.matchfunwords.repository

import it.iacovelli.matchfunwords.model.Match
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MatchRepository: MongoRepository<Match, String> {

    fun findByPrivate(private: Boolean): List<Match>

}