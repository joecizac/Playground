package com.jozze.playground.topic08_clean_architecture

import com.jozze.playground.core.logging.LearningLogger
import com.jozze.playground.topic08_clean_architecture.practice_notes.PracticeNoteDto
import com.jozze.playground.topic08_clean_architecture.practice_notes.toDomain
import com.jozze.playground.topic08_clean_architecture.practice_notes.toDto
import com.jozze.playground.topic08_clean_architecture.practice_notes.toUiModel

/**
 * Data mapping.
 *
 * Mapping creates boundaries between network/storage DTOs, domain entities, and
 * UI models. It adds code, but it prevents accidental coupling between layers.
 */
fun runDataMappingDemo(logger: LearningLogger) {
    val topic = "topic08/data-mapping"
    val dto = PracticeNoteDto("n4", "Mapping", "DTO -> Domain -> UI", reviewed = false)
    val domain = dto.toDomain()
    val ui = domain.toUiModel()

    logger.info(topic, "dto=$dto")
    logger.info(topic, "domain=$domain")
    logger.info(topic, "ui=$ui")
    logger.debug(topic, "round trip dto=${domain.toDto()}")

    /*
    Wrong:
    data class PracticeNoteDto(val buttonText: String, val isLoading: Boolean)

    Why wrong:
    DTOs should model transport/storage data, not UI concerns. UI state belongs
    in the presentation layer.
    */
}
