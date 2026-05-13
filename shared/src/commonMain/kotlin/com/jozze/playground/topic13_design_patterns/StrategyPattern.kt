package com.jozze.playground.topic13_design_patterns

import com.jozze.playground.core.logging.LearningLogger

/**
 * Strategy pattern.
 *
 * Strategy makes an algorithm interchangeable. Kotlin functions are often enough
 * when the strategy has no state.
 */
fun runStrategyPatternDemo(logger: LearningLogger) {
    val topic = "topic13/strategy"
    val next = chooseNextTopic(listOf("Kotlin", "Flows", "Compose")) { topics ->
        topics.first { it.length > 5 }
    }

    logger.info(topic, "next topic=$next")

    /*
    Wrong:
    fun choose(mode: String) = when (mode) { "long" -> ... }

    Why wrong:
    String modes spread algorithm choices through the function. A strategy makes
    the choice explicit and type-safe.
    */
}

private fun chooseNextTopic(
    topics: List<String>,
    strategy: (List<String>) -> String,
): String = strategy(topics)
