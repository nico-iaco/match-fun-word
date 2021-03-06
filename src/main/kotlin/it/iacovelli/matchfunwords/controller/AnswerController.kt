package it.iacovelli.matchfunwords.controller

import it.iacovelli.matchfunwords.model.Answer
import it.iacovelli.matchfunwords.service.AnswerService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/answer")
class AnswerController(private val answerService: AnswerService) {

    @GetMapping("/", produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllAnswer(): ResponseEntity<List<Answer>> {
        return ResponseEntity.ok(answerService.getAllAnswer())
    }

}