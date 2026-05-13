package com.jozze.playground.topic05_coroutines

import com.jozze.playground.core.logging.LearningLogger
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * Suspend functions.
 *
 * A suspend function can suspend without blocking its thread. The compiler
 * rewrites suspend functions into continuation-passing state machines.
 */
fun runSuspendFunctionsDemo(logger: LearningLogger) = runBlocking {
    val topic = "topic05/suspend-functions"
    logger.info(topic, "profile=${loadProfileName()}")
    logger.debug(topic, "The caller suspends at `delay`, but the thread is free for other work.")

    /*
    Wrong:
    suspend fun load(): String {
        Thread.sleep(1000)
        return "done"
    }

    Why wrong:
    `Thread.sleep` blocks the thread. Use suspending APIs such as `delay` or
    dispatcher-backed blocking wrappers when doing real blocking work.
    */
}

private suspend fun loadProfileName(): String {
    delay(10)
    return "Kotlin Learner"
}
