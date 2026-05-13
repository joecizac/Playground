package com.jozze.playground.topic02_kotlin_advanced

import com.jozze.playground.core.logging.LearningLogger
import kotlin.properties.Delegates

/**
 * Delegation.
 *
 * Property delegation forwards property behavior to a delegate object. Class
 * delegation forwards interface implementation to another object.
 */
fun runDelegationDemo(logger: LearningLogger) {
    val topic = "topic02/delegation"
    val repository = LoggingRepository(InMemoryRepository())
    val settings = DemoSettings()

    settings.theme = "dark"
    logger.info(topic, "lazy token=${settings.sessionToken}")
    logger.info(topic, repository.load())

    /*
    Wrong:
    class HugeRepository : Cache, Network, Logger, Parser { ... }

    Why wrong:
    Class delegation can compose focused implementations instead of building one
    class that owns unrelated responsibilities.
    */
}

private class DemoSettings {
    val sessionToken: String by lazy { "created-on-first-access" }

    var theme: String by Delegates.observable("light") { _, old, new ->
        // Real examples can log this callback; here it proves the delegate runs.
        require(old != new) { "new theme should differ in this demo" }
    }
}

private interface Repository {
    fun load(): String
}

private class InMemoryRepository : Repository {
    override fun load(): String = "data-from-memory"
}

private class LoggingRepository(
    private val delegate: Repository,
) : Repository by delegate
