package dev.pfilaretov42.spring.data.jdbc.jsonb.service

import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.CreateFriendResponseDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.FriendsFullResponseDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.FriendsRequestDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.dto.FriendsResponseDto
import dev.pfilaretov42.spring.data.jdbc.jsonb.exception.FriendsNotFoundException
import dev.pfilaretov42.spring.data.jdbc.jsonb.mapper.FriendsMapper
import dev.pfilaretov42.spring.data.jdbc.jsonb.repository.FriendsRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class FriendsService(
    private val friendsRepository: FriendsRepository,
    private val friendsMapper: FriendsMapper,
) {
    fun getAll(): FriendsResponseDto {
        val entities = friendsRepository.findAll()
        return friendsMapper.toDto(entities)
    }

    fun get(id: UUID): FriendsFullResponseDto {
        val entity = friendsRepository.findByIdOrNull(id)
            ?: throw FriendsNotFoundException("Cannot find friend with id=$id")
        return friendsMapper.toDto(entity)
    }

    @Transactional
    fun create(request: FriendsRequestDto): CreateFriendResponseDto {
        val entity = friendsMapper.fromDto(request)
        val createdEntity = friendsRepository.save(entity)
        return CreateFriendResponseDto(createdEntity.id)
    }

}


