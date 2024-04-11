package dev.pfilaretov42.spring.data.jdbc.jsonb.entity

import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("friends")
class FriendsEntity(
    val id: UUID,
    val fullName: String,
    val alias: String,
    val superpower: String,
)