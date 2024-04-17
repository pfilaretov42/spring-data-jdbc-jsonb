package dev.pfilaretov42.spring.data.jdbc.jsonb.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("friends")
class FriendsEntity(
    @Id
    val id: UUID,
    val fullName: String,
    val alias: String,
    val superpower: SuperpowerEntity,
    val extras: Map<String, Any?>?,
)

class SuperpowerEntity(
    val abilities: List<String>,
    val weapon: List<String>,
    val rating: Int,
)