package com.jozze.playground.topic10_mvi

data class PracticeNotesMviState(
    val isLoading: Boolean = false,
    val notes: List<String> = emptyList(),
    val error: String? = null,
)

sealed interface PracticeNotesIntent {
    data object LoadClicked : PracticeNotesIntent
    data class NoteClicked(val id: String) : PracticeNotesIntent
}

sealed interface PracticeNotesEffect {
    data object LoadNotes : PracticeNotesEffect
    data class NavigateToNote(val id: String) : PracticeNotesEffect
}

data class ReduceResult(
    val state: PracticeNotesMviState,
    val effects: List<PracticeNotesEffect> = emptyList(),
)

fun reducePracticeNotes(
    state: PracticeNotesMviState,
    intent: PracticeNotesIntent,
): ReduceResult = when (intent) {
    PracticeNotesIntent.LoadClicked -> ReduceResult(
        state = state.copy(isLoading = true, error = null),
        effects = listOf(PracticeNotesEffect.LoadNotes),
    )
    is PracticeNotesIntent.NoteClicked -> ReduceResult(
        state = state,
        effects = listOf(PracticeNotesEffect.NavigateToNote(intent.id)),
    )
}
