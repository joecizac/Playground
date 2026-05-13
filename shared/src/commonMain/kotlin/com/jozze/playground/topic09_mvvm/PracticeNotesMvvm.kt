package com.jozze.playground.topic09_mvvm

import com.jozze.playground.topic08_clean_architecture.practice_notes.GetPracticeNotesUseCase
import com.jozze.playground.topic08_clean_architecture.practice_notes.PracticeNoteUiModel
import com.jozze.playground.topic08_clean_architecture.practice_notes.toUiModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class PracticeNotesUiState(
    val isLoading: Boolean = false,
    val notes: List<PracticeNoteUiModel> = emptyList(),
    val errorMessage: String? = null,
)

sealed interface PracticeNotesAction {
    data object Load : PracticeNotesAction
    data class OpenNote(val id: String) : PracticeNotesAction
}

sealed interface PracticeNotesEvent {
    data class NavigateToNote(val id: String) : PracticeNotesEvent
}

/**
 * ViewModel-shaped class for shared MVVM examples.
 *
 * This is not Android's `ViewModel` so the lesson can compile in commonMain. The
 * same state and event pattern transfers to an Android ViewModel with viewModelScope.
 */
class PracticeNotesViewModelLike(
    private val getPracticeNotes: GetPracticeNotesUseCase,
    private val scope: CoroutineScope,
) {
    private val mutableState = MutableStateFlow(PracticeNotesUiState())
    val state: StateFlow<PracticeNotesUiState> = mutableState.asStateFlow()

    private val mutableEvents = MutableSharedFlow<PracticeNotesEvent>()
    val events: SharedFlow<PracticeNotesEvent> = mutableEvents.asSharedFlow()

    fun onAction(action: PracticeNotesAction) {
        when (action) {
            PracticeNotesAction.Load -> load()
            is PracticeNotesAction.OpenNote -> scope.launch {
                mutableEvents.emit(PracticeNotesEvent.NavigateToNote(action.id))
            }
        }
    }

    private fun load() {
        scope.launch {
            mutableState.value = PracticeNotesUiState(isLoading = true)
            runCatching { getPracticeNotes().map { it.toUiModel() } }
                .onSuccess { notes -> mutableState.value = PracticeNotesUiState(notes = notes) }
                .onFailure { error -> mutableState.value = PracticeNotesUiState(errorMessage = error.message) }
        }
    }
}
