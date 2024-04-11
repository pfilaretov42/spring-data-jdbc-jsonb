package dev.pfilaretov42.spring.data.jdbc.jsonb.mapper

import com.fasterxml.jackson.databind.ObjectMapper
import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.FriendsFullResponseDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.FriendsResponseDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.FriendsSuperpowerDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.entity.FriendsEntity
import org.springframework.stereotype.Component

@Component
class FriendsMapperImpl(
    private val objectMapper: ObjectMapper,
) : FriendsMapper {
    override fun toDto(entities: List<FriendsEntity>) = FriendsResponseDto(
        friends = entities.map { entity ->
            FriendsFullResponseDto(
                id = entity.id,
                fullName = entity.fullName,
                alias = entity.alias,
                superpower = objectMapper.readValue(entity.superpower, FriendsSuperpowerDto::class.java)
            )
        }
    )
}