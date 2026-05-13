package com.jozze.playground.topic08_clean_architecture.practice_notes

/**
 * Domain entity for the Phase 4 architecture examples.
 *
 * This type is pure Kotlin: no Android, database, network, or UI dependencies.
 */
data class PracticeNote(
    val id: NoteId,
    val topic: String,
    val body: String,
    val isReviewed: Boolean,
)

@JvmInline
value class NoteId(val value: String)

interface PracticeNoteRepository {
    suspend fun notes(): List<PracticeNote>
    suspend fun save(note: PracticeNote)
}

class GetPracticeNotesUseCase(
    private val repository: PracticeNoteRepository,
) {
    suspend operator fun invoke(): List<PracticeNote> = repository.notes()
}

class SavePracticeNoteUseCase(
    private val repository: PracticeNoteRepository,
) {
    suspend operator fun invoke(note: PracticeNote) {
        require(note.topic.isNotBlank()) { "topic is required" }
        require(note.body.isNotBlank()) { "body is required" }
        repository.save(note)
    }
}
