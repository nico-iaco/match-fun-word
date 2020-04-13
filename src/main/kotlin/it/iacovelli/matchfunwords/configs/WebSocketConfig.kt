package it.iacovelli.matchfunwords.configs

import it.iacovelli.matchfunwords.model.enum.UserRole
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry

@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfig : AbstractWebSocketMessageBrokerConfigurer() {

    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint("/match-fun-words")
        registry.addEndpoint("/match-fun-words").withSockJS()
    }

    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        registry.enableSimpleBroker("/game")
        registry.setApplicationDestinationPrefixes("/app")
    }

//    override fun configureInbound(messages: MessageSecurityMetadataSourceRegistry) {
//        messages.nullDestMatcher().permitAll()
//                .simpDestMatchers("/app/**").hasRole(UserRole.USER.name)
//                .simpSubscribeDestMatchers("/game/ " + "**").hasRole(UserRole.USER.name)
//                .anyMessage().denyAll();
//    }
//
//    override fun sameOriginDisabled(): Boolean {
//        return false
//    }
}