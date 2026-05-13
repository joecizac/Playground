package com.jozze.playground.topic05_coroutines

import com.jozze.playground.core.logging.LearningLogger
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

/**
 * Cancellation.
 *
 * Coroutine cancellation is cooperative. Suspending functions check cancellation,
 * and CPU loops should check `isActive` or call `yield`.
 */
fun runCancellationDemo(logger: LearningLogger) = runBlocking {
    val topic = "topic05/cancellation"
    val job = launch {
        var iteration = 0
        try {
            while (isActive) {
                iteration++
                yield()
            }
        } catch (error: CancellationException) {
            logger.warning(topic, "CancellationException is normal cancellation: ${error::class.simpleName}")
            throw error
        } finally {
            logger.info(topic, "cancelled after iterations=$iteration")
        }
    }

    delay(10)
    job.cancelAndJoin()

    /*
    Wrong:
    catch (error: Exception) { logger.error("ignored", error.message ?: "") }

    Why wrong:
    Broad catches can swallow CancellationException. If you catch it for cleanup,
    rethrow it so cancellation keeps propagating.
    */
}
