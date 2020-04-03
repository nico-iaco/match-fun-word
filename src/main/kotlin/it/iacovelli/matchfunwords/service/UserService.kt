package it.iacovelli.matchfunwords.service

import it.iacovelli.matchfunwords.exception.UserNotFoundException
import it.iacovelli.matchfunwords.model.User
import it.iacovelli.matchfunwords.model.dto.UserDto
import it.iacovelli.matchfunwords.model.mapper.UserMapper
import it.iacovelli.matchfunwords.repository.UserRepository
import it.iacovelli.matchfunwords.utils.JwtUtils
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Service
class UserService(val userRepository: UserRepository,
                  val passwordEncoder: PasswordEncoder,
                  val userMapper: UserMapper,
                  val authenticationManager: AuthenticationManager,
                  val jwtUtils: JwtUtils) {

    fun registerUser(user: User): Boolean {
        try {
            user.password = passwordEncoder.encode(user.password)
            userRepository.save(user)
        } catch (e: Exception) {
            return false
        }
        return true
    }

    fun login(username: String, pwd: String): UserDto {
        val authentication: Authentication = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(username, pwd))

        SecurityContextHolder.getContext().authentication = authentication
        val jwt: String = jwtUtils.generateJwtToken(authentication)
        val userOptional = userRepository.findByUsername(username)
        if (userOptional.isPresent) {
            return userMapper.fromUserToDto(userOptional.get(), jwt)
        } else {
            throw UserNotFoundException("Nessun utente trovato")
        }
    }

}