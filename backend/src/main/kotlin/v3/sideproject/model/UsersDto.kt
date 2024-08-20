package v3.sideproject.model

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotNull

data class UsersDto(
        @field:NotNull(message = "ID cannot be null")
        val userId: Long,
        val name: String?,
        @field:Email(message = "Email should be valid")
        val email: String
)