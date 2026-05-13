package com.jozze.playground.topic08_clean_architecture.practice_notes

/**
 * Data-layer DTO and repository implementation for the architecture examples.
 *
 * DTOs model storage/network shape. They are mapped into domain entities before
 * crossing the repository boundary.
 */
data class PracticeNoteDto(
    val id: String,
    val topicName: String,
    val markdownBody: String,
    val reviewed: Boolean,
)

class InMemoryPracticeNoteDataSource(
    initialNotes: List<PracticeNoteDto> = listOf(
        PracticeNoteDto("n1", "Clean Architecture", "Keep domain pure.", reviewed = true),
        PracticeNoteDto("n2", "MVVM", "Expose immutable UI state.", reviewed = false),
    ),
) {
    private val notes = initialNotes.toMutableList()

    fun all(): List<PracticeNoteDto> = notes.toList()

    fun upsert(note: PracticeNoteDto) {
        val index = notes.indexOfFirst { it.id == note.id }
        if (index >= 0) notes[index] = note else notes += note
    }
}

class InMemoryPracticeNoteRepository(
    private val dataSource: InMemoryPracticeNoteDataSource,
) : PracticeNoteRepository {
    override suspend fun notes(): List<PracticeNote> = dataSource.all().map { it.toDomain() }

    override suspend fun save(note: PracticeNote) {
        dataSource.upsert(note.toDto())
    }
}

fun PracticeNoteDto.toDomain(): PracticeNote = PracticeNote(
    id = NoteId(id),
    topic = topicName,
    body = markdownBody,
    isReviewed = reviewed,
)

fun PracticeNote.toDto(): PracticeNoteDto = PracticeNoteDto(
    id = id.value,
    topicName = topic,
    markdownBody = body,
    reviewed = isReviewed,
)
