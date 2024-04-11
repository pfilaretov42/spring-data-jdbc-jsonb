package dev.pfilaretov42.spring.data.jdbc.jsonb.service

import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.FriendsResponseDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.mapper.FriendsMapper
import dev.pfilaretov42.spring.data.jdbc.jsonb.repository.FriendsRepository
import org.springframework.stereotype.Service

@Service
class FriendsService(
    private val friendsRepository: FriendsRepository,
    private val friendsMapper: FriendsMapper,
) {
    fun getAll(): FriendsResponseDto {
        val entities = friendsRepository.findAll()
        return friendsMapper.toDto(entities)
    }


}
