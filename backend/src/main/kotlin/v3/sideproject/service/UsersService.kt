package v3.sideproject.service

import v3.sideproject.model.UsersDto

interface UsersService {
    fun getAllUsers(): List<UsersDto>
}