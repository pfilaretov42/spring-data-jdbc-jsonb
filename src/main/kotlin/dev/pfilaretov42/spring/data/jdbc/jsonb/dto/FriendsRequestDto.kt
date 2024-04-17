package dev.pfilaretov42.spring.data.jdbc.jsonb.dto


class FriendsRequestDto(
    val friend: FriendsFullRequestDto,
)

class FriendsFullRequestDto(
    val fullName: String,
    val alias: String,
    val superpower: FriendsSuperpowerRequestDto,
    val extras: Map<String, Any?>?,
)

class FriendsSuperpowerRequestDto(
    val abilities: List<String>,
    val weapon: List<String>,
    val rating: Int,
)
