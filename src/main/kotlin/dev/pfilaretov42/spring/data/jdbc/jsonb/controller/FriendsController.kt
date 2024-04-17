package dev.pfilaretov42.spring.data.jdbc.jsonb.controller

import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.CreateFriendResponseDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.FriendsFullResponseDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.FriendsRequestDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.FriendsResponseDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.service.FriendsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
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
    fun createFriend(@RequestBody request: FriendsRequestDto): CreateFriendResponseDto =
        friendsService.create(request)
}