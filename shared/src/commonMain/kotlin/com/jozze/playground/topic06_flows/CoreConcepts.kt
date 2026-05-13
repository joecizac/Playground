package com.jozze.playground.topic06_flows

import com.jozze.playground.core.logging.LearningLogger
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Flow core concepts.
 *
 * Cold flows run separately for every collector. Hot streams such as
 * `SharedFlow` exist independently of collectors and emit from active producers.
 */
fun runFlowCoreConceptsDemo(logger: LearningLogger) = runBlocking {
    val topic = "topic06/core"
    var starts = 0
    val cold = flow {
        starts++
        emit("cold-start-$starts")
    }

    logger.info(topic, "first collect=${cold.toList()}")
    logger.info(topic, "second collect=${cold.toList()}")

    val hot = MutableSharedFlow<String>(replay = 1)
    hot.emit("latest-hot-value")
    val job = launch {
        hot.collect { value ->
            logger.info(topic, "hot collector received=$value")
            return@collect
        }
    }
    job.cancel()

    /*
    Wrong:
    val flow = flow { emit(api.load()) }
    // expecting api.load() to run immediately

    Why wrong:
    Cold flows do nothing until collected.
    */
}
