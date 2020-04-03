package it.iacovelli.matchfunwords.service

import it.iacovelli.matchfunwords.model.Question
import it.iacovelli.matchfunwords.repository.QuestionRepository
import org.springframework.stereotype.Service

@Service
class QuestionService(private val repository: QuestionRepository) {

    fun addQuestion(question: Question) {
        repository.save(question)
    }

    fun addAllQuestion(questions: List<Question>) {
        repository.saveAll(questions)
    }

    fun getAllQuestion(): List<Question> {
        return repository.findAll()
    }

    fun getQuestionBySlot(slot: Int): List<Question> {
        return repository.findBySlot(slot)
    }

}