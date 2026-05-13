package com.jozze.playground.topic01_kotlin_basics

import com.jozze.playground.core.logging.LearningLogger

/**
 * Visibility modifiers.
 *
 * `public` is the default. `private` hides details in a file/class. `internal`
 * exposes APIs only inside the module. `protected` exposes members to subclasses.
 */
fun runVisibilityModifiersDemo(logger: LearningLogger) {
    val topic = "topic01/visibility"
    val report = PublicReport("Phase 1")

    logger.info(topic, report.visibleSummary())
    logger.debug(topic, "private helper output is reachable only through public/internal behavior.")

    /*
    Wrong:
    class Repository { public val cache = mutableMapOf<String, String>() }

    Why wrong:
    Exposing mutable internals lets callers break invariants. Keep internals
    private and expose focused operations.
    */
}

private class PublicReport(private val title: String) : BaseReport() {
    fun visibleSummary(): String = "title=$title owner=${protectedOwner()}"
}

private open class BaseReport {
    protected fun protectedOwner(): String = "shared-module"
}
