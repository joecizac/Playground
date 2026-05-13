package com.jozze.playground.topic01_kotlin_basics

import com.jozze.playground.core.logging.LearningLogger

/**
 * Classes and objects.
 *
 * Primary constructors define the main creation path. `init` blocks validate or
 * derive state. Secondary constructors should delegate to the primary one.
 */
fun runClassesAndObjectsDemo(logger: LearningLogger) {
    val topic = "topic01/classes"
    val course = LearningCourse(title = "Kotlin", lessons = 12)
    val defaultCourse = LearningCourse("Compose")

    logger.info(topic, course.summary)
    logger.info(topic, "secondary constructor result=${defaultCourse.summary}")
    logger.info(topic, "custom setter coerced progress=${course.apply { progressPercent = 140 }.progressPercent}")

    /*
    Wrong:
    class Course { var lessons: Int = -1 }

    Why wrong:
    Invalid state is easy to create. Prefer constructor validation so objects are
    valid immediately after creation.
    */
}

private class LearningCourse(
    val title: String,
    val lessons: Int,
) {
    var progressPercent: Int = 0
        set(value) {
            field = value.coerceIn(0, 100)
        }

    val summary: String
        get() = "$title has $lessons lessons"

    init {
        require(lessons > 0) { "lessons must be positive" }
    }

    constructor(title: String) : this(title = title, lessons = 1)
}
