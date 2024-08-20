package v3.sideproject.service.impl

import org.springframework.stereotype.Service
import v3.sideproject.model.UsersDto
import v3.sideproject.repository.UsersRepository
import v3.sideproject.service.UsersService

@Service
class UsersServiceImpl(
        private val usersRepository: UsersRepository
) : UsersService {
    override fun getAllUsers(): List<UsersDto> {
        val users: List<UsersDto> = usersRepository.selectAllUsers();
        return users;
    }

}