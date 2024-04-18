package dev.pfilaretov42.spring.data.jdbc.jsonb.config

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
    private val stringWritingConverter: StringWritingConverter,
    private val stringReadingConverter: StringReadingConverter,
) : AbstractJdbcConfiguration() {
    override fun userConverters(): MutableList<*> {
        return mutableListOf(
            stringWritingConverter,
            stringReadingConverter,
        )
    }
}

@Component
@WritingConverter
class StringWritingConverter : Converter<String, PGobject> {
    override fun convert(source: String): PGobject {
        val jsonObject = PGobject()
        jsonObject.type = "jsonb"
        jsonObject.value = source
        return jsonObject
    }
}

@Component
@ReadingConverter
class StringReadingConverter : Converter<PGobject, String> {
    override fun convert(pgObject: PGobject): String? {
        return pgObject.value
    }
}
