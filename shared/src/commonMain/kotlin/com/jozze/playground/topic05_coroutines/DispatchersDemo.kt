package com.jozze.playground.topic05_coroutines

import com.jozze.playground.core.logging.LearningLogger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * Dispatchers.
 *
 * Dispatchers decide where coroutine code runs. `Default` is for CPU-bound work,
 * `IO` is for blocking IO on JVM/Android, and `Unconfined` starts in the current
 * call frame before resuming wherever the suspension chooses.
 */
fun runDispatchersDemo(logger: LearningLogger) = runBlocking {
    val topic = "topic05/dispatchers"
    launch(Dispatchers.Default) {
        logger.info(topic, "Default dispatcher example calculated=${fib(8)}")
    }.join()

    val result = withContext(Dispatchers.Default) {
        "computed on Default"
    }
    logger.info(topic, result)
    logger.warning(topic, "Use Dispatchers.Main from UI code; this common demo avoids Main because it needs a platform main dispatcher.")

    /*
    Wrong:
    launch(Dispatchers.Default) { blockingDatabaseCall() }

    Why wrong:
    Blocking IO can starve CPU worker threads. Use `Dispatchers.IO` for blocking
    file, database, or network calls on platforms where it is available.
    */
}

private fun fib(value: Int): Int = if (value <= 1) value else fib(value - 1) + fib(value - 2)
