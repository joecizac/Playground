package com.jozze.playground.topic02_kotlin_advanced

import com.jozze.playground.core.logging.LearningLogger

/**
 * Object expressions and declarations.
 *
 * `object` declarations create singletons. Object expressions create anonymous
 * objects, often for one-off implementations. Companion objects hold members
 * associated with a class rather than an instance.
 */
fun runObjectExpressionsAndDeclarationsDemo(logger: LearningLogger) {
    val topic = "topic02/objects"
    val listener = object : EventListener {
        override fun onEvent(name: String): String = "anonymous listener handled $name"
    }

    logger.info(topic, AppRegistry.register("topic02"))
    logger.info(topic, listener.onEvent("click"))
    logger.info(topic, LessonSummary.create("Objects").title)

    /*
    Wrong:
    object GlobalMutableSession { var token: String? = null }

    Why wrong:
    Global mutable state hides lifecycle and ownership. Prefer injected state
    holders or scoped dependencies for session data.
    */
}

private interface EventListener {
    fun onEvent(name: String): String
}

private object AppRegistry {
    private var count = 0

    fun register(name: String): String {
        count += 1
        return "registered $name count=$count"
    }
}

private data class LessonSummary(val title: String) {
    companion object LessonFactory {
        fun create(title: String): LessonSummary = LessonSummary(title)
    }
}
