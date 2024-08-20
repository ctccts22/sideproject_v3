package v3.sideproject.repository.impl

import org.jooq.DSLContext
import org.jooq.SelectField
import org.springframework.stereotype.Repository
import v3.sideproject.model.UsersDto
import v3.sideproject.repository.UsersRepository
import v3.sideproject.tables.Users.USERS

@Repository
class UsersRepositoryImpl(
        private val dsl: DSLContext
) : UsersRepository {


    override fun selectAllUsers(): List<UsersDto> {
        val result: List<UsersDto> =
                dsl
                        .select(
                                USERS.USER_ID,
                                USERS.NAME,
                                USERS.EMAIL
                        )
                        .from(USERS)
                        .fetchInto(UsersDto::class.java)
        return result
    }

}