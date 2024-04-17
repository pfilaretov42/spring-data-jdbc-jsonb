package dev.pfilaretov42.spring.data.jdbc.jsonb.controller

import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.CreateFriendResponseDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.FriendsFullResponseDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.FriendsRequestDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.FriendsResponseDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.service.FriendsService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/v1/friends")
class FriendsController(
    private val friendsService: FriendsService,
) {

    @GetMapping
    fun getAllFriends(): FriendsResponseDto = friendsService.getAll()

    @GetMapping("/{id}")
    fun getFriend(@PathVariable("id") id: UUID): FriendsFullResponseDto = friendsService.get(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createFriend(@RequestBody request: FriendsRequestDto): CreateFriendResponseDto =
        friendsService.create(request)

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateFriend(@PathVariable("id") id: UUID, @RequestBody request: FriendsRequestDto) {
        friendsService.update(id, request)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteFriend(@PathVariable("id") id: UUID) {
        friendsService.delete(id)
    }


}