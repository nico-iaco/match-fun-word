package it.iacovelli.matchfunwords.model

import it.iacovelli.matchfunwords.model.enum.UserRole
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
data class User(
        @Id
        val _id: ObjectId,
        @Indexed(unique = true)
        var email: String,
        @Indexed(unique = true)
        var username: String,
        var password: String
) {
    var name: String = ""
    var surname: String = ""
    var role: UserRole = UserRole.USER
}