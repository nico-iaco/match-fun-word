package it.iacovelli.matchfunwords.controller

import it.iacovelli.matchfunwords.model.Question
import it.iacovelli.matchfunwords.service.QuestionService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/question")
class QuestionController(private val questionService: QuestionService) {

    @GetMapping("/", produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllQuestion(): ResponseEntity<List<Question>> {
        return ResponseEntity.ok(questionService.getAllQuestion())
    }

    @GetMapping("/slot/{slot}", produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun getQuestionBySlot(@PathVariable("slot") slot: Int): ResponseEntity<List<Question>> {
        return ResponseEntity.ok(questionService.getQuestionBySlot(slot))
    }

}