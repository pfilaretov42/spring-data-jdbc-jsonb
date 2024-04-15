package dev.pfilaretov42.spring.data.jdbc.jsonb.config

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import dev.pfilaretov42.spring.data.jdbc.jsonb.entity.SuperpowerEntity
import org.postgresql.util.PGobject
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.ReadingConverter
import org.springframework.data.convert.WritingConverter
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration
import org.springframework.stereotype.Component

/**
 * Configuration to register custom writing/reading converters to/from JSONB column
 */
@Configuration
class JdbcConfig(
    private val superpowerEntityWritingConverter: SuperpowerEntityWritingConverter,
    private val superpowerEntityReadingConverter: SuperpowerEntityReadingConverter,
    private val mapWritingConverter: MapWritingConverter,
    private val mapReadingConverter: MapReadingConverter,
) : AbstractJdbcConfiguration() {
    override fun userConverters(): MutableList<*> {
        return mutableListOf(
            superpowerEntityWritingConverter,
            superpowerEntityReadingConverter,
            mapWritingConverter,
            mapReadingConverter,
        )
    }
}

@Component
@WritingConverter
class SuperpowerEntityWritingConverter(
    private val objectMapper: ObjectMapper,
) : Converter<SuperpowerEntity, PGobject> {
    override fun convert(source: SuperpowerEntity): PGobject {
        val jsonObject = PGobject()
        jsonObject.type = "jsonb"
        jsonObject.value = objectMapper.writeValueAsString(source)
        return jsonObject
    }
}

@Component
@ReadingConverter
class SuperpowerEntityReadingConverter(
    private val objectMapper: ObjectMapper,
) : Converter<PGobject, SuperpowerEntity> {
    override fun convert(pgObject: PGobject): SuperpowerEntity {
        val source = pgObject.value
        return objectMapper.readValue(source, SuperpowerEntity::class.java)
    }
}

@Component
@WritingConverter
class MapWritingConverter(
    private val objectMapper: ObjectMapper,
) : Converter<Map<String, Any?>, PGobject> {
    override fun convert(source: Map<String, Any?>): PGobject {
        val jsonObject = PGobject()
        jsonObject.type = "jsonb"
        jsonObject.value = objectMapper.writeValueAsString(source)
        return jsonObject
    }
}

@Component
@ReadingConverter
class MapReadingConverter(
    private val objectMapper: ObjectMapper,
) : Converter<PGobject, Map<String, Any?>> {
    override fun convert(pgObject: PGobject): Map<String, Any?> {
        val source = pgObject.value
        return objectMapper.readValue(source, object : TypeReference<Map<String, Any?>>() {})
    }
}
