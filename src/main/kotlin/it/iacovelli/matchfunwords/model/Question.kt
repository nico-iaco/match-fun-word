package it.iacovelli.matchfunwords.model

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "questions")
data class Question( var text: String ) {
    var slot: Int = 0
}