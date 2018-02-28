package io.ermdev.classify.controller

import io.ermdev.alice.entity.User
import io.ermdev.classify.data.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("users")
class UserController(@Autowired var userService: UserService) {

    @GetMapping("{userId}")
    fun getById(@PathVariable("userId") userId: Long): ResponseEntity<User> {
        return ResponseEntity(userService.findById(userId), HttpStatus.FOUND)
    }

    @GetMapping()
    fun getById(): ResponseEntity<List<User>> {
        return ResponseEntity(userService.findAll(), HttpStatus.FOUND)
    }
}