package dev.pfilaretov42.spring.data.jdbc.jsonb.mapper

import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.FriendsResponseDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.entity.FriendsEntity

interface FriendsMapper {
    fun toDto(entities: List<FriendsEntity>): FriendsResponseDto
}