package it.iacovelli.matchfunwords.model.mapper

import it.iacovelli.matchfunwords.model.User
import it.iacovelli.matchfunwords.model.dto.UserDto
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
abstract class UserMapper {

    @InheritInverseConfiguration
    abstract fun fromUserToDto(user: User, jwt: String): UserDto

}