package dev.pfilaretov42.spring.data.jdbc.jsonb.mapper

import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.FriendsFullResponseDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.FriendsResponseDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.FriendsSuperpowerDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.entity.FriendsEntity
import dev.pfilaretov42.spring.data.jdbc.jsonb.entity.SuperpowerEntity
import org.springframework.stereotype.Component

@Component
class FriendsMapperImpl : FriendsMapper {
    override fun toDto(entities: List<FriendsEntity>) = FriendsResponseDto(
        friends = entities.map { entity ->
            FriendsFullResponseDto(
                id = entity.id,
                fullName = entity.fullName,
                alias = entity.alias,
                superpower = toDto(entity.superpower),
            )
        }
    )

    private fun toDto(entity: SuperpowerEntity) = FriendsSuperpowerDto(
        abilities = entity.abilities,
        weapon = entity.weapon,
        rating = entity.rating,
    )
}