package com.jozze.playground.topic08_clean_architecture

import com.jozze.playground.core.logging.LearningLogger
import com.jozze.playground.topic08_clean_architecture.practice_notes.GetPracticeNotesUseCase
import com.jozze.playground.topic08_clean_architecture.practice_notes.InMemoryPracticeNoteDataSource
import com.jozze.playground.topic08_clean_architecture.practice_notes.InMemoryPracticeNoteRepository
import com.jozze.playground.topic08_clean_architecture.practice_notes.toUiModel
import kotlinx.coroutines.runBlocking

/**
 * Presentation layer.
 *
 * Presentation code turns domain results into state that a UI can render. It
 * should not know whether data came from network, cache, database, or memory.
 */
fun runPresentationLayerDemo(logger: LearningLogger) = runBlocking {
    val topic = "topic08/presentation-layer"
    val notes = GetPracticeNotesUseCase(
        InMemoryPracticeNoteRepository(InMemoryPracticeNoteDataSource()),
    )().map { it.toUiModel() }

    logger.info(topic, "ui models=$notes")

    /*
    Wrong:
    Text(noteDto.markdownBody)

    Why wrong:
    UI is now coupled to DTO fields. A UI model can expose names and formatting
    that are stable for rendering.
    */
}
