package it.iacovelli.matchfunwords.configs.filter

import it.iacovelli.matchfunwords.service.MongoUserDetailService
import it.iacovelli.matchfunwords.utils.JwtUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.util.StringUtils
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthTokenFilter: OncePerRequestFilter() {

    @Autowired
    lateinit var jwtUtils: JwtUtils

    @Autowired
    lateinit var mongoUserDetailService: MongoUserDetailService

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        try {
            val jwt = parseJwt(request)
            if (jwtUtils.validateJwtToken(jwt)) {
                val username: String = jwtUtils.getUserNameFromJwtToken(jwt)
                val userDetails: UserDetails = mongoUserDetailService.loadUserByUsername(username)
                val authentication = UsernamePasswordAuthenticationToken(userDetails, null,
                        userDetails.authorities)
                authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = authentication
            }
        } catch (e: Exception) {
            logger.error("Cannot set user authentication: {}", e)
        }

        filterChain.doFilter(request, response)
    }

    private fun parseJwt(request: HttpServletRequest): String {
        val headerAuth = request.getHeader("Authorization")
        if (StringUtils.hasText(headerAuth)) {
            if (headerAuth.startsWith("Bearer ")) {
                return headerAuth.substring(7)
            } else {
                throw RuntimeException("Unable to parse JWT, Authorization header must start with \"Bearer \"")
            }
        } else {
            throw RuntimeException("Unable to parse JWT, header \"Authorization\" must not be empty")
        }
    }
}