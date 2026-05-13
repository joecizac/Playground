package com.jozze.playground.topic13_design_patterns

import com.jozze.playground.core.logging.LearningLogger

/**
 * Factory Method pattern.
 *
 * A factory centralizes object creation when callers should not know the exact
 * implementation class or construction rule.
 */
fun runFactoryMethodPatternDemo(logger: LearningLogger) {
    val topic = "topic13/factory"
    val reminder = ReminderFactory.create(type = "review", target = "Flows")
    logger.info(topic, reminder.message())

    /*
    Wrong:
    if (type == "review") ReviewReminder(...) else DeadlineReminder(...)
    // repeated at every call site

    Why wrong:
    Creation policy is duplicated. A factory keeps the decision in one place.
    */
}

private interface Reminder {
    fun message(): String
}

private data class ReviewReminder(private val target: String) : Reminder {
    override fun message(): String = "Review $target"
}

private data class DeadlineReminder(private val target: String) : Reminder {
    override fun message(): String = "Finish $target"
}

private object ReminderFactory {
    fun create(type: String, target: String): Reminder = when (type) {
        "review" -> ReviewReminder(target)
        else -> DeadlineReminder(target)
    }
}
