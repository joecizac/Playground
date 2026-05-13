package com.jozze.playground.topic05_coroutines

import com.jozze.playground.core.logging.LearningLogger
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Coroutine context and scope.
 *
 * A `CoroutineScope` owns a context. The context combines dispatcher, job, name,
 * and other elements. Scopes define how long launched work is allowed to live.
 */
fun runCoroutineContextAndScopeDemo(logger: LearningLogger) = runBlocking {
    val topic = "topic05/context-scope"
    val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default + CoroutineName("LearningScope"))
    val job = scope.launch {
        logger.info(topic, "context name=${coroutineContext[CoroutineName]?.name}")
    }

    job.join()
    scope.cancel()
    logger.debug(topic, "Created and cancelled an owned scope.")

    /*
    Wrong:
    GlobalScope.launch { syncForever() }

    Why wrong:
    GlobalScope work is detached from screen, ViewModel, or application lifetimes.
    Prefer a scope owned by the lifecycle that should cancel the work.
    */
}
