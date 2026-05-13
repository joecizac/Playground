package com.jozze.playground.topic05_coroutines

import com.jozze.playground.core.logging.LearningLogger
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Job and Deferred.
 *
 * `Job` represents lifecycle and cancellation. `Deferred<T>` is a `Job` that
 * also produces a value through `await`.
 */
fun runJobAndDeferredDemo(logger: LearningLogger) = runBlocking {
    val topic = "topic05/job-deferred"
    val job = launch {
        delay(10)
        logger.info(topic, "Job completed without returning a value")
    }
    val deferred = async {
        delay(10)
        42
    }

    logger.debug(topic, "job active before join=${job.isActive}")
    job.join()
    logger.info(topic, "deferred value=${deferred.await()}")

    /*
    Wrong:
    val result = async { expensiveWork() }
    // never await result

    Why wrong:
    If the value matters, `await` it. If no value matters, use `launch` to make
    the intent clear.
    */
}
