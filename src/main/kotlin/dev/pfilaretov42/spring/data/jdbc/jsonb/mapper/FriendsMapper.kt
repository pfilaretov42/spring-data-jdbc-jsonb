package dev.pfilaretov42.spring.data.jdbc.jsonb.mapper

import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.FriendsFullResponseDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.FriendsRequestDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.FriendsResponseDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.entity.FriendsEntity
import java.util.*

interface FriendsMapper {
    fun toDto(entities: List<FriendsEntity>): FriendsResponseDto

    fun toDto(entity: FriendsEntity): FriendsFullResponseDto

    fun fromDto(id: UUID? = null, dto: FriendsRequestDto): FriendsEntity
}