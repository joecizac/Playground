package com.jozze.playground.topic01_kotlin_basics

import com.jozze.playground.core.logging.LearningLogger

/**
 * Sequences.
 *
 * Collections process each intermediate operation eagerly. Sequences process
 * lazily and run intermediate operations only when a terminal operation asks for
 * values.
 */
fun runSequencesDemo(logger: LearningLogger) {
    val topic = "topic01/sequences"
    val eager = (1..5)
        .map { it * 2 }
        .filter { it > 5 }

    val lazy = (1..5)
        .asSequence()
        .map { it * 2 }
        .filter { it > 5 }
        .take(2)
        .toList()

    logger.info(topic, "eager collection result=$eager")
    logger.info(topic, "lazy sequence terminal result=$lazy")
    logger.debug(topic, "Sequence work happens when terminal operation `toList` runs.")

    /*
    Wrong:
    val tiny = listOf(1, 2, 3).asSequence().map { it + 1 }.toList()

    Why potentially wrong:
    Sequences add overhead. For tiny collections or simple transformations,
    regular collection operators are often clearer and fast enough.
    */
}
