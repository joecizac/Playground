package com.jozze.playground.topic05_coroutines

import com.jozze.playground.core.logging.LearningLogger
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * Structured concurrency.
 *
 * Parent coroutines wait for children. Failure and cancellation propagate through
 * the hierarchy, making async work easier to reason about.
 */
fun runStructuredConcurrencyDemo(logger: LearningLogger) = runBlocking {
    val topic = "topic05/structured-concurrency"
    val combined = loadDashboard()
    logger.info(topic, "combined=$combined")
    logger.debug(topic, "loadDashboard returns only after both children complete.")

    /*
    Wrong:
    fun loadDashboard() {
        someScope.launch { loadUser() }
        someScope.launch { loadStats() }
    }

    Why wrong:
    The caller cannot know when the work finishes or whether one child failed.
    Use `coroutineScope` when child results belong to one operation.
    */
}

private suspend fun loadDashboard(): String = coroutineScope {
    val user = async {
        delay(10)
        "Ada"
    }
    val stats = async {
        delay(10)
        "3 lessons"
    }
    "${user.await()} - ${stats.await()}"
}
