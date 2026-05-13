package com.jozze.playground.topic01_kotlin_basics

import com.jozze.playground.core.logging.LearningLogger

/**
 * Variables and data types.
 *
 * `val` creates a read-only reference; `var` creates a mutable reference. Kotlin
 * basic types such as `Int`, `Long`, `Boolean`, and `Double` are modeled as
 * classes in source code, while the compiler can map them to JVM primitives when
 * possible on Android/JVM.
 */
fun runVariablesAndDataTypesDemo(logger: LearningLogger) {
    val topic = "topic01/variables"
    val stableName: String = "Ada"
    var score: Int = 10
    score += 5

    val letters: Array<String> = arrayOf("K", "M", "P")
    val message = "Student=$stableName score=$score letters=${letters.joinToString("")}"

    logger.info(topic, message)
    logger.debug(topic, "Right way: prefer val until mutation is required.")
    logger.debug(topic, "String templates keep formatting readable: Hello, $stableName.")

    /*
    Wrong:
    var mutableForNoReason = "initial"

    Why wrong:
    A mutable reference suggests this value will change. Use `val` when the
    reference should stay stable.

    Wrong:
    val numbers = arrayOf(1, 2, 3)
    numbers = arrayOf(4, 5, 6)

    Why wrong:
    `val` prevents reassigning the reference. The array contents may still be
    mutable; choose immutable collections when you need immutable contents too.
    */
}
