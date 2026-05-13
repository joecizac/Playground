package com.jozze.playground.topic13_design_patterns

import com.jozze.playground.core.logging.LearningLogger

/**
 * Singleton pattern.
 *
 * Kotlin `object` creates a thread-safe singleton on the JVM. Use it for
 * stateless utilities or process-wide constants, not hidden mutable app state.
 */
fun runSingletonPatternDemo(logger: LearningLogger) {
    val topic = "topic13/singleton"
    logger.info(topic, LearningIdGenerator.nextId("note"))

    /*
    Wrong:
    object SessionStore { var authToken: String? = null }

    Why wrong:
    Global mutable state hides ownership, lifecycle, and test setup. Prefer DI or
    an explicitly scoped state holder.
    */
}

private object LearningIdGenerator {
    private var counter = 0

    fun nextId(prefix: String): String {
        counter += 1
        return "$prefix-$counter"
    }
}
