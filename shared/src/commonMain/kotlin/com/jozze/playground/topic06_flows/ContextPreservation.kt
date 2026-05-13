package com.jozze.playground.topic06_flows

import com.jozze.playground.core.logging.LearningLogger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * Context preservation.
 *
 * Flow preserves context: upstream emission runs in its own context, and
 * collection runs in the collector's context. Use `flowOn` to move upstream
 * work. Do not switch context inside `flow {}` around `emit`.
 */
fun runContextPreservationDemo(logger: LearningLogger) = runBlocking {
    val topic = "topic06/context"
    val values = flow {
        emit("upstream value")
    }.flowOn(Dispatchers.Default).toList()

    logger.info(topic, "flowOn result=$values")
    logger.debug(topic, "flowOn moved upstream work without changing collector code.")

    /*
    Wrong:
    flow {
        withContext(Dispatchers.Default) {
            emit(value)
        }
    }

    Why wrong:
    Emitting from a different context inside `flow {}` violates flow context
    preservation. Use `flowOn` for upstream dispatcher changes.
    */
    withContext(Dispatchers.Default) {
        logger.debug(topic, "withContext is fine outside emission when you explicitly need a context switch.")
    }
}
