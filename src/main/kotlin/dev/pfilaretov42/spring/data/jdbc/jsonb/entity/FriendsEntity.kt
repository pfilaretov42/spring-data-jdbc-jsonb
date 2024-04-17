package dev.pfilaretov42.spring.data.jdbc.jsonb.entity

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Transient
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("friends")
class FriendsEntity(
    @Id
    @Column("id")
    val uuid: UUID,
    val fullName: String,
    val alias: String,
    val superpower: SuperpowerEntity,
    val extras: Map<String, Any?>?,
) : Persistable<UUID> {

    @Transient
    var isNewEntity = false

    override fun getId(): UUID = uuid

    override fun isNew(): Boolean = isNewEntity
}

class SuperpowerEntity(
    val abilities: List<String>,
    val weapon: List<String>,
    val rating: Int,
)