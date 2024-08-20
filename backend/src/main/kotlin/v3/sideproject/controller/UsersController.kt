package v3.sideproject.controller

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import v3.sideproject.model.UsersDto
import v3.sideproject.service.UsersService


@RestController
@RequestMapping(path = ["/api/users"], produces = [MediaType.APPLICATION_JSON_VALUE])
class UsersController(
        private val usersService : UsersService
) {

    @GetMapping
    fun fetchAll(): ResponseEntity<List<UsersDto>> {
        val users = usersService.getAllUsers();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(users);
    }
}