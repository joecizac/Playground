package com.jozze.playground.topic09_mvvm

import com.jozze.playground.core.logging.LearningLogger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

/**
 * ViewModel lifecycle.
 *
 * Android ViewModels survive configuration changes and clear their scope when
 * the ViewModel is finished. Shared examples model this with an owned scope.
 */
fun runMvvmViewModelLifecycleDemo(logger: LearningLogger) {
    val topic = "topic09/lifecycle"
    val scope = CoroutineScope(SupervisorJob())
    logger.info(topic, "scope represents viewModelScope lifetime in common code")
    scope.cancel()
    logger.info(topic, "scope cancelled when ViewModel is cleared")

    /*
    Wrong:
    val scope = CoroutineScope(SupervisorJob())
    // never cancelled

    Why wrong:
    Work can outlive the screen/model that owns it. Tie coroutine scope lifetime
    to the ViewModel lifecycle.
    */
}
