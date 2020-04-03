package it.iacovelli.matchfunwords.controller

import it.iacovelli.matchfunwords.model.Question
import it.iacovelli.matchfunwords.service.QuestionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/question")
class QuestionController(private val questionService: QuestionService) {

    @GetMapping("/")
    fun getAllQuestion(): ResponseEntity<List<Question>> {
        return ResponseEntity.ok(questionService.getAllQuestion())
    }

    @GetMapping("/slot/{slot}")
    fun getQuestionBySlot(@PathVariable("slot") slot: Int): ResponseEntity<List<Question>> {
        return ResponseEntity.ok(questionService.getQuestionBySlot(slot))
    }

}