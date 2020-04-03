package it.iacovelli.matchfunwords.controller

import it.iacovelli.matchfunwords.model.User
import it.iacovelli.matchfunwords.model.dto.UserDto
import it.iacovelli.matchfunwords.model.request.LoginRequest
import it.iacovelli.matchfunwords.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/user")
class UserController(val userService: UserService) {

    @PostMapping("/login")
    fun login(@Valid @RequestBody loginRequest: LoginRequest) : ResponseEntity<UserDto> {
        return ResponseEntity.ok(userService.login(loginRequest.username, loginRequest.pwd))
    }

    @PostMapping("/register")
    fun register(@Valid @RequestBody user: User) : ResponseEntity<Boolean> {
        return ResponseEntity.ok(userService.registerUser(user))
    }



}