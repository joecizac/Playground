package com.jozze.playground.topic01_kotlin_basics

import com.jozze.playground.core.logging.LearningLogger

/**
 * Inheritance.
 *
 * Kotlin classes and functions are final by default. Mark them `open` only when
 * extension is intended and supported by the contract.
 */
fun runInheritanceDemo(logger: LearningLogger) {
    val topic = "topic01/inheritance"
    val lesson: Lesson = VideoLesson("Inheritance", durationMinutes = 8)

    logger.info(topic, lesson.describe())
    logger.info(topic, "super call included=${lesson.describe().contains("Lesson")}")

    /*
    Wrong:
    open class MutableBase { open var state = "" }

    Why wrong:
    Open mutable state is hard to reason about because subclasses can change
    behavior and storage rules. Prefer narrow open functions with clear contracts.
    */
}

private open class Lesson(private val title: String) {
    open fun describe(): String = "Lesson: $title"
}

private class VideoLesson(
    title: String,
    private val durationMinutes: Int,
) : Lesson(title) {
    override fun describe(): String = "${super.describe()} ($durationMinutes min video)"
}
