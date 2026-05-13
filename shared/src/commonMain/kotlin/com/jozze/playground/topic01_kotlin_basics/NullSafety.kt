package com.jozze.playground.topic01_kotlin_basics

import com.jozze.playground.core.logging.LearningLogger

/**
 * Null safety.
 *
 * `String` means a value is required. `String?` means absence is part of the
 * model. Safe calls, Elvis, and explicit checks keep null handling visible.
 */
fun runNullSafetyDemo(logger: LearningLogger) {
    val topic = "topic01/null-safety"
    val maybeName: String? = "Compose"
    val missingName: String? = null

    logger.info(topic, "safe length=${maybeName?.length}")
    logger.info(topic, "fallback name=${missingName ?: "Anonymous"}")
    logger.info(topic, "explicit check=${describeName(maybeName)}")

    /*
    Wrong:
    val length = missingName!!.length

    Why wrong:
    `!!` converts a nullable value into a crash if it is null. It is only
    appropriate when a violated invariant should fail immediately and loudly.
    */
}

private fun describeName(name: String?): String {
    return if (name == null) "No name supplied" else "Name '$name' has ${name.length} characters"
}
