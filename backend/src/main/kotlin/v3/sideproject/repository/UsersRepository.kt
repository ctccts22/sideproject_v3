package v3.sideproject.repository

import v3.sideproject.model.UsersDto

interface UsersRepository {
    fun selectAllUsers(): List<UsersDto>
}