package it.iacovelli.matchfunwords.utils

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class AuthenticationUtils {

    fun getUserNameFromSecurity(): String {
        return SecurityContextHolder.getContext().authentication.name
    }

}