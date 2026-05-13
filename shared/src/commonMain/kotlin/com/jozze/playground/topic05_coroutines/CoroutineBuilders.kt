package com.jozze.playground.topic05_coroutines

import com.jozze.playground.core.logging.LearningLogger
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Coroutine builders.
 *
 * `launch` starts fire-and-forget work and returns a `Job`. `async` starts work
 * that produces a value through `Deferred`. `runBlocking` bridges regular code
 * into suspend code and should mainly be used in demos, tests, and main entry
 * points, not inside Android UI event handlers in production.
 */
fun runCoroutineBuildersDemo(logger: LearningLogger) = runBlocking {
    val topic = "topic05/builders"
    val job = launch {
        delay(10)
        logger.info(topic, "launch completed side-effect work")
    }
    val deferred = async {
        delay(10)
        "async result"
    }

    logger.debug(topic, "runBlocking keeps this demo synchronous for the catalog runner.")
    job.join()
    logger.info(topic, "awaited ${deferred.await()}")

    /*
    Wrong:
    runBlocking { networkCall() } // inside an Android button click

    Why wrong:
    `runBlocking` blocks the current thread. In production UI code, launch from a
    lifecycle-aware scope such as viewModelScope or lifecycleScope.
    */
}
