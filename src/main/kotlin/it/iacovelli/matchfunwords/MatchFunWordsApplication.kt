package it.iacovelli.matchfunwords

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources

@SpringBootApplication
@PropertySource("classpath:database.properties")
class MatchFunWordsApplication

fun main(args: Array<String>) {
    runApplication<MatchFunWordsApplication>(*args)
}
