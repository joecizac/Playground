package com.jozze.playground.topic06_flows

import com.jozze.playground.core.logging.LearningLogger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking

/**
 * Converting cold flows to hot flows.
 *
 * `stateIn` converts a cold flow into `StateFlow`. `shareIn` converts a cold
 * flow into `SharedFlow`. `SharingStarted` controls when upstream collection
 * starts and stops.
 */
fun runStateInAndShareInDemo(logger: LearningLogger) = runBlocking {
    val topic = "topic06/stateIn-shareIn"
    val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)
    val cold = flow {
        emit("first")
        emit("second")
    }

    val state = cold.stateIn(
        scope = scope,
        started = SharingStarted.Eagerly,
        initialValue = "initial",
    )
    logger.info(topic, "stateIn latest=${state.value}")

    val shared = cold.shareIn(
        scope = scope,
        started = SharingStarted.Eagerly,
        replay = 2,
    )
    logger.info(topic, "shareIn replay=${shared.take(2).toList()}")
    scope.cancel()

    /*
    Wrong:
    repository.flow.stateIn(GlobalScope, SharingStarted.Eagerly, initial)

    Why wrong:
    Hot flows need an owned scope. Use a scope whose lifetime matches the cache,
    ViewModel, or application component.
    */
}
