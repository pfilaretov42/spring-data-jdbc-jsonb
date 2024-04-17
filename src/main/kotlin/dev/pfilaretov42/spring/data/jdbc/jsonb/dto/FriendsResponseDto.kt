package dev.pfilaretov42.spring.data.jdbc.jsonb.dto

import java.util.*

class FriendsResponseDto(
    val friends: List<FriendsFullResponseDto>,
)

class FriendsFullResponseDto(
    val id: UUID,
    val fullName: String,
    val alias: String,
    val superpower: FriendsSuperpowerResponseDto,
    val extras: Map<String, Any?>?,
)

class FriendsSuperpowerResponseDto(
    val abilities: List<String>,
    val weapon: List<String>,
    val rating: Int,
)

class CreateFriendResponseDto(
    val id: UUID,
)