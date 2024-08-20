package v3.sideproject.exception

import org.springframework.http.HttpStatus


class APIException : RuntimeException {
    private val status: HttpStatus
    override val message: String

    constructor(status: HttpStatus, message: String) {
        this.status = status
        this.message = message
    }

    constructor(message: String?, status: HttpStatus, message1: String) : super(message) {
        this.status = status
        this.message = message1
    }
}