package it.iacovelli.matchfunwords.model

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "answers")
data class Answer (
        val text: String
)