package it.iacovelli.matchfunwords.repository

import it.iacovelli.matchfunwords.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository: MongoRepository<User, String> {

    fun findByUsername(username: String): Optional<User>

    fun findByUsernameAndPassword(username: String, password: String): Optional<User>

}