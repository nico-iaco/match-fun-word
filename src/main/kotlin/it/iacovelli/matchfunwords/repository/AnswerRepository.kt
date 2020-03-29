package it.iacovelli.matchfunwords.repository

import it.iacovelli.matchfunwords.model.Answer
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface AnswerRepository: MongoRepository<Answer, ObjectId> {
}