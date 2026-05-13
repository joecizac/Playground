package com.jozze.playground.topic08_clean_architecture

import com.jozze.playground.core.logging.LearningLogger
import com.jozze.playground.topic08_clean_architecture.practice_notes.NoteId
import com.jozze.playground.topic08_clean_architecture.practice_notes.PracticeNote
import com.jozze.playground.topic08_clean_architecture.practice_notes.SavePracticeNoteUseCase
import kotlinx.coroutines.runBlocking

/**
 * Domain layer.
 *
 * The domain layer contains business entities and use cases. It should be pure
 * Kotlin and easy to test without Android or infrastructure.
 */
fun runDomainLayerDemo(logger: LearningLogger) = runBlocking {
    val topic = "topic08/domain-layer"
    val repository = RecordingPracticeNoteRepository()
    val save = SavePracticeNoteUseCase(repository)
    val note = PracticeNote(NoteId("n3"), "Domain", "Pure business rule.", isReviewed = false)

    save(note)
    logger.info(topic, "saved domain note=${repository.saved.single()}")

    /*
    Wrong:
    data class PracticeNote(val context: android.content.Context, ...)

    Why wrong:
    Android framework types make domain code platform-specific and harder to
    reuse in KMP common code.
    */
}
