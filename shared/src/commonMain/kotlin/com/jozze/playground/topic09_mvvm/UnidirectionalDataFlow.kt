package com.jozze.playground.topic09_mvvm

import com.jozze.playground.core.logging.LearningLogger
import com.jozze.playground.topic08_clean_architecture.practice_notes.GetPracticeNotesUseCase
import com.jozze.playground.topic08_clean_architecture.practice_notes.InMemoryPracticeNoteDataSource
import com.jozze.playground.topic08_clean_architecture.practice_notes.InMemoryPracticeNoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * Unidirectional Data Flow.
 *
 * UI sends actions to the ViewModel. The ViewModel updates immutable state. UI
 * observes state and renders it.
 */
fun runMvvmUnidirectionalDataFlowDemo(logger: LearningLogger) = runBlocking {
    val topic = "topic09/udf"
    val scope = CoroutineScope(SupervisorJob())
    val viewModel = PracticeNotesViewModelLike(
        getPracticeNotes = GetPracticeNotesUseCase(InMemoryPracticeNoteRepository(InMemoryPracticeNoteDataSource())),
        scope = scope,
    )

    viewModel.onAction(PracticeNotesAction.Load)
    delay(20)
    logger.info(topic, "state after Load=${viewModel.state.value}")
    scope.cancel()

    /*
    Wrong:
    view.renderLoading()
    view.renderNotes(notes)

    Why wrong:
    Imperative rendering calls split the source of truth. Emit one state object
    and let the View render from it.
    */
}
