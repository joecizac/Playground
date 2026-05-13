package com.jozze.playground.topic13_design_patterns

import com.jozze.playground.core.logging.LearningLogger

/**
 * Decorator pattern.
 *
 * A decorator wraps behavior with additional responsibilities. Kotlin extension
 * functions can also decorate values when stateful wrapping is unnecessary.
 */
fun runDecoratorPatternDemo(logger: LearningLogger) {
    val topic = "topic13/decorator"
    val base: TextFormatter = PlainTextFormatter()
    val decorated = ReviewedBadgeFormatter(base)

    logger.info(topic, decorated.format("Coroutines"))
    logger.info(topic, "extension decorator=${"Flows".withPracticePrefix()}")

    /*
    Wrong:
    class PlainTextFormatter { fun formatReviewed(); fun formatWarning(); fun formatSuccess(); }

    Why wrong:
    The base class accumulates combinations. Decorators compose behavior without
    bloating the original type.
    */
}

private interface TextFormatter {
    fun format(text: String): String
}

private class PlainTextFormatter : TextFormatter {
    override fun format(text: String): String = text
}

private class ReviewedBadgeFormatter(
    private val delegate: TextFormatter,
) : TextFormatter {
    override fun format(text: String): String = "[Reviewed] ${delegate.format(text)}"
}

private fun String.withPracticePrefix(): String = "Practice: $this"
