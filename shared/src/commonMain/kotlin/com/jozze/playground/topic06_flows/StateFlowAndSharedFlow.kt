package com.jozze.playground.topic06_flows

import com.jozze.playground.core.logging.LearningLogger
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * StateFlow and SharedFlow.
 *
 * `StateFlow` always has an initial value and conflates to the latest state.
 * `SharedFlow` is configurable and is often used for events.
 */
fun runStateFlowAndSharedFlowDemo(logger: LearningLogger) = runBlocking {
    val topic = "topic06/state-shared"
    val state = MutableStateFlow("Idle")
    state.value = "Loading"
    state.value = "Content"
    logger.info(topic, "StateFlow latest=${state.value}")

    val events = MutableSharedFlow<String>(replay = 1)
    events.emit("Snackbar")
    logger.info(topic, "SharedFlow replayed first=${events.first()}")

    val collected = mutableListOf<String>()
    val job = launch {
        events.take(2).toList(collected)
    }
    events.emit("Navigate")
    events.emit("Toast")
    job.join()
    logger.info(topic, "SharedFlow collected=$collected")

    /*
    Wrong:
    val navigation = MutableStateFlow<String?>(null)

    Why often wrong:
    Navigation is usually an event, not durable screen state. A replaying or
    non-replaying SharedFlow models one-off events more directly.
    */
}
