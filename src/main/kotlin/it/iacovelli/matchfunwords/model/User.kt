package it.iacovelli.matchfunwords.model

import it.iacovelli.matchfunwords.model.enum.UserRole
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "users")
data class User(
        @Indexed(unique = true)
        var email: String,
        @Indexed(unique = true)
        var username: String,
        var password: String
) {

    @Id
    var _id: ObjectId = ObjectId()
    var name: String = ""
    var surname: String = ""
    var role: UserRole = UserRole.USER


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (email != other.email) return false

        return true
    }

    override fun hashCode(): Int {
        return email.hashCode()
    }


}