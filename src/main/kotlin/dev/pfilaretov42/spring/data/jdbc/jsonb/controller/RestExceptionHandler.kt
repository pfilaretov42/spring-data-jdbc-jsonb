package dev.pfilaretov42.spring.data.jdbc.jsonb.controller

import dev.pfilaretov42.spring.data.jdbc.jsonb.exception.FriendsNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class RestExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler
    fun handleNotFound(e: FriendsNotFoundException): ResponseEntity<Nothing> {
        return ResponseEntity.notFound().build()
    }
}