package com.jozze.playground.topic09_mvvm

import com.jozze.playground.core.logging.LearningLogger
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

/**
 * One-off events.
 *
 * Navigation and snackbars are events, not durable state. `SharedFlow` can model
 * event delivery without the common SingleLiveEvent anti-pattern.
 */
fun runMvvmOneOffEventsDemo(logger: LearningLogger) = runBlocking {
    val topic = "topic09/events"
    val events = MutableSharedFlow<PracticeNotesEvent>(replay = 1)
    events.emit(PracticeNotesEvent.NavigateToNote("n1"))

    logger.info(topic, "event=${events.first()}")

    /*
    Wrong:
    data class UiState(val navigateTo: String?)

    Why wrong:
    Durable state can replay navigation after rotation. Prefer an event stream
    when the action should be consumed once.
    */
}
