package it.iacovelli.matchfunwords.configs

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfig : WebSocketMessageBrokerConfigurer {

    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint("/match-fun-words").setAllowedOrigins("*")
        registry.addEndpoint("/match-fun-words").setAllowedOrigins("*").withSockJS()
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