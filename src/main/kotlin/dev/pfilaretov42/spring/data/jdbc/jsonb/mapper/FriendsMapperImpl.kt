package dev.pfilaretov42.spring.data.jdbc.jsonb.mapper

import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.FriendsFullResponseDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.FriendsRequestDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.FriendsResponseDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.FriendsSuperpowerRequestDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.FriendsSuperpowerResponseDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.entity.FriendsEntity
import dev.pfilaretov42.spring.data.jdbc.jsonb.entity.SuperpowerEntity
import org.springframework.stereotype.Component
import java.util.*

@Component
class FriendsMapperImpl : FriendsMapper {
    override fun toDto(entities: List<FriendsEntity>) = FriendsResponseDto(
        friends = entities.map { toDto(it) }
    )

    override fun toDto(entity: FriendsEntity) = FriendsFullResponseDto(
        id = entity.id,
        fullName = entity.fullName,
        alias = entity.alias,
        superpower = toDto(entity.superpower),
        extras = entity.extras,
    )

    private fun toDto(entity: SuperpowerEntity) = FriendsSuperpowerResponseDto(
        abilities = entity.abilities,
        weapon = entity.weapon,
        rating = entity.rating,
    )

    override fun fromDto(dto: FriendsRequestDto) = FriendsEntity(
        // TODO - generate id,
        //  next step - need to make sure that entity is marked as new for spring data
        id = UUID.randomUUID(),
        fullName = dto.friend.fullName,
        alias = dto.friend.alias,
        superpower = fromDto(dto.friend.superpower),
        extras = dto.friend.extras,
    )

    private fun fromDto(dto: FriendsSuperpowerRequestDto) = SuperpowerEntity(
        abilities = dto.abilities,
        weapon = dto.weapon,
        rating = dto.rating,
    )
}