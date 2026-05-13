package com.jozze.playground.topic01_kotlin_basics

import com.jozze.playground.core.logging.LearningLogger

/**
 * Functions.
 *
 * Kotlin supports regular function bodies, default arguments, named arguments,
 * and single-expression functions.
 */
fun runFunctionsDemo(logger: LearningLogger) {
    val topic = "topic01/functions"
    logger.info(topic, greet(name = "Kotlin learner"))
    logger.info(topic, "area=${rectangleArea(width = 4, height = 3)} doubled=${double(9)}")

    /*
    Wrong:
    fun greet(name: String, punctuation: String) = "Hello, $name$punctuation"
    greet("Ada", "!")

    Why wrong:
    Positional arguments become harder to read as parameters grow. Defaults and
    named arguments make call sites self-documenting.
    */
}

private fun greet(name: String, punctuation: String = "!"): String = "Hello, $name$punctuation"

private fun rectangleArea(width: Int, height: Int): Int {
    return width * height
}

private fun double(value: Int): Int = value * 2
