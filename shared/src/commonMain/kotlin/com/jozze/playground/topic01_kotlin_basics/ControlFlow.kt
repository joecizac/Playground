package com.jozze.playground.topic01_kotlin_basics

import com.jozze.playground.core.logging.LearningLogger

/**
 * Control flow.
 *
 * Kotlin `if` and `when` can be statements or expressions. Prefer expression
 * form when the branches produce one value.
 */
fun runControlFlowDemo(logger: LearningLogger) {
    val topic = "topic01/control-flow"
    val score = 86
    val grade = if (score >= 90) "A" else if (score >= 75) "B" else "C"
    val badge = when (grade) {
        "A" -> "excellent"
        "B" -> "solid"
        else -> "keep practicing"
    }

    var countdown = 3
    val ticks = mutableListOf<Int>()
    while (countdown > 0) {
        ticks += countdown
        countdown--
    }

    logger.info(topic, "score=$score grade=$grade badge=$badge")
    logger.info(topic, "for loop squares=${(1..3).map { it * it }} while ticks=$ticks")

    /*
    Wrong:
    var label = ""
    if (score >= 75) label = "pass" else label = "retry"

    Why wrong:
    This works, but expression form is clearer when choosing a single value:
    val label = if (score >= 75) "pass" else "retry"
    */
}
