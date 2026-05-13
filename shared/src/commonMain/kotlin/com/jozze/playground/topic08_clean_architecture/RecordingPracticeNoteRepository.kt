package com.jozze.playground.topic08_clean_architecture

import com.jozze.playground.topic08_clean_architecture.practice_notes.PracticeNote
import com.jozze.playground.topic08_clean_architecture.practice_notes.PracticeNoteRepository

class RecordingPracticeNoteRepository : PracticeNoteRepository {
    val saved = mutableListOf<PracticeNote>()

    override suspend fun notes(): List<PracticeNote> = saved.toList()

    override suspend fun save(note: PracticeNote) {
        saved += note
    }
}
