package dev.pfilaretov42.spring.data.jdbc.jsonb.repository

import dev.pfilaretov42.spring.data.jdbc.jsonb.entity.FriendsEntity
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import java.util.*

interface FriendsRepository : CrudRepository<FriendsEntity, UUID> {
    override fun findAll(): List<FriendsEntity>

    @Query("select * from friends where (superpower->>'rating')::NUMERIC > :rating order by alias")
    fun findBySuperpowerRatingGreaterThan(rating: Int): List<FriendsEntity>

}