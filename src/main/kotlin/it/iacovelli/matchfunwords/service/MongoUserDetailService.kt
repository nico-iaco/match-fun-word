package it.iacovelli.matchfunwords.service

import it.iacovelli.matchfunwords.repository.UserRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class MongoUserDetailService(private val repository: UserRepository) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user = repository.findByUsername(username).orElseThrow { UsernameNotFoundException("Nessun utente trovato") }
        val grantedAuthorities: List<SimpleGrantedAuthority> = listOf(SimpleGrantedAuthority(user.role.name))
        return User(user.username, user.password, grantedAuthorities)
    }

}