package it.iacovelli.matchfunwords.service

import it.iacovelli.matchfunwords.model.Answer
import it.iacovelli.matchfunwords.repository.AnswerRepository
import org.springframework.stereotype.Service

@Service
class AnswerService(private val repository: AnswerRepository) {

    fun addAnswer(answer: Answer) {
        repository.save(answer)
    }

    fun addAllAnswer(answers: List<Answer>) {
        repository.saveAll(answers)
    }

    fun getAllAnswer(): List<Answer> {
        return repository.findAll()
    }

}