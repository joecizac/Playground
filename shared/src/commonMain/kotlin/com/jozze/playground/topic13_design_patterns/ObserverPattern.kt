package com.jozze.playground.topic13_design_patterns

import com.jozze.playground.core.logging.LearningLogger
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * Observer pattern.
 *
 * Flow and StateFlow are modern Kotlin ways to observe changing values.
 */
fun runObserverPatternDemo(logger: LearningLogger) {
    val topic = "topic13/observer"
    val progress = MutableStateFlow(0)
    progress.value = 50
    progress.value = 100

    logger.info(topic, "latest observed progress=${progress.value}")

    /*
    Wrong:
    object ProgressBus { val listeners = mutableListOf<(Int) -> Unit>() }

    Why wrong:
    Manual listener buses often leak listeners and have unclear threading. Prefer
    lifecycle-aware observable primitives such as Flow/StateFlow.
    */
}
