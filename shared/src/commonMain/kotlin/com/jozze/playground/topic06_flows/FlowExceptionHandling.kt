package com.jozze.playground.topic06_flows

import com.jozze.playground.core.logging.LearningLogger
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking

/**
 * Flow exception handling.
 *
 * `catch` handles exceptions from upstream operators. It is transparent to
 * downstream exceptions, which keeps collector failures visible.
 */
fun runFlowExceptionHandlingDemo(logger: LearningLogger) = runBlocking {
    val topic = "topic06/exceptions"
    val recovered = flow {
        emit("before failure")
        error("upstream failure")
    }.catch { error ->
        logger.error(topic, "catch recovered upstream failure", error)
        emit("fallback")
    }.toList()

    logger.info(topic, "recovered=$recovered")

    runCatching {
        flow {
            emit("value")
        }.catch {
            emit("not used")
        }.onEach {
            error("downstream failure")
        }.toList()
    }.onFailure { logger.warning(topic, "downstream exception bypassed upstream catch: ${it.message}") }

    /*
    Wrong:
    flow.catch { emit(emptyList()) } // hides all failures without logging or state

    Why wrong:
    Silent fallback makes debugging difficult. Convert failures into explicit UI
    state or log/report them before recovery.
    */
}
