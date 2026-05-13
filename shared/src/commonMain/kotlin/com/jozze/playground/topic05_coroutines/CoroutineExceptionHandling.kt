package com.jozze.playground.topic05_coroutines

import com.jozze.playground.core.logging.LearningLogger
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

/**
 * Coroutine exception handling.
 *
 * Exceptions in `launch` are reported to a handler when uncaught. Exceptions in
 * `async` are observed through `await`. `supervisorScope` lets siblings survive
 * a child failure when that is the intended policy.
 */
fun runCoroutineExceptionHandlingDemo(logger: LearningLogger) = runBlocking {
    val topic = "topic05/exceptions"
    val handler = CoroutineExceptionHandler { _, error ->
        logger.error(topic, "launch reported to CoroutineExceptionHandler", error)
    }

    launch(handler) {
        error("launch failure")
    }.join()

    supervisorScope {
        val failed = async { error("async failure") }
        runCatching { failed.await() }
            .onFailure { logger.error(topic, "async failure is observed at await", it) }
        launch { logger.info(topic, "sibling still runs inside supervisorScope") }.join()
    }

    runCatching {
        coroutineScope {
            launch { error("regular scope child failure") }
        }
    }.onFailure { logger.warning(topic, "coroutineScope propagates child failure: ${it.message}") }

    /*
    Wrong:
    val handler = CoroutineExceptionHandler { _, _ -> }

    Why wrong:
    Empty handlers hide failures. Log, report, or convert failures into explicit
    state so they can be diagnosed.
    */
}
