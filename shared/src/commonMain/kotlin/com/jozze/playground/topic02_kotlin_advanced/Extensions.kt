package com.jozze.playground.topic02_kotlin_advanced

import com.jozze.playground.core.logging.LearningLogger

/**
 * Extension functions and properties.
 *
 * Extensions are resolved statically from the declared receiver type. They do
 * not actually add members to the target class and they cannot override members.
 */
fun runExtensionsDemo(logger: LearningLogger) {
    val topic = "topic02/extensions"
    val title = "kotlin multiplatform"

    logger.info(topic, "titleCase=${title.toTitleCase()}")
    logger.info(topic, "wordCount=${title.wordCount}")
    logger.debug(topic, "Extension calls compile to functions with the receiver passed as an argument.")

    /*
    Wrong:
    fun String.length(): Int = 42

    Why wrong:
    Members win over extensions. This does not override `String.length`; it also
    creates confusing API names. Use extensions for additive behavior.
    */
}

private fun String.toTitleCase(): String = split(" ").joinToString(" ") { word ->
    word.replaceFirstChar { it.uppercase() }
}

private val String.wordCount: Int
    get() = trim().split(" ").filter { it.isNotBlank() }.size
