package it.iacovelli.matchfunwords.controller

import it.iacovelli.matchfunwords.model.Match
import it.iacovelli.matchfunwords.service.MatchService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/match")
class MatchController(private val matchService: MatchService) {

    @PostMapping("/")
    fun createMatch(authentication: Authentication): ResponseEntity<String> {
        return ResponseEntity.ok(matchService.createMatch(authentication.name))
    }

    @PostMapping("/{matchId}/join")
    fun partecipateToMatch(@PathVariable matchId: String, authentication: Authentication): ResponseEntity<Boolean> {
        return ResponseEntity.ok(matchService.partecipateToMatch(authentication.name, matchId))
    }

    @PostMapping("/{matchId}/exit")
    fun exitFromMatch(@PathVariable matchId: String, authentication: Authentication): ResponseEntity<Boolean> {
        return ResponseEntity.ok(matchService.removePlayerFromMatch(authentication.name, matchId))
    }

    @DeleteMapping("/{matchId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun finishMatch(@PathVariable matchId: String) {
        matchService.finishMatch(matchId)
    }

    @GetMapping("/public")
    fun getAllPublicMatches(): ResponseEntity<List<Match>> {
        return ResponseEntity.ok(matchService.getPublicMatches())
    }

}