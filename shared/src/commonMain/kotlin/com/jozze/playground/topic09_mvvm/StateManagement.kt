package com.jozze.playground.topic09_mvvm

import com.jozze.playground.core.logging.LearningLogger
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * MVVM state management.
 *
 * `StateFlow` is a good default for durable UI state because it always exposes a
 * latest value and works naturally with Compose state collection.
 */
fun runMvvmStateManagementDemo(logger: LearningLogger) {
    val topic = "topic09/state"
    val mutableState = MutableStateFlow(PracticeNotesUiState(isLoading = true))
    mutableState.value = PracticeNotesUiState(notes = listOf())

    logger.info(topic, "latest state=${mutableState.value}")
    logger.debug(topic, "Expose StateFlow, not MutableStateFlow, from production ViewModels.")

    /*
    Wrong:
    val state = MutableStateFlow(...)

    Why wrong:
    Public mutable state lets the UI mutate ViewModel state directly. Keep
    MutableStateFlow private and expose StateFlow.
    */
}
