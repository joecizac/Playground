package com.jozze.playground.topic02_kotlin_advanced

import com.jozze.playground.core.logging.LearningLogger

/**
 * Inline functions and reified types.
 *
 * `inline` asks the compiler to copy the function body at call sites. Reified
 * type parameters are available only in inline functions and allow runtime type
 * checks that normal erased generic parameters cannot perform.
 */
fun runInlineAndReifiedTypesDemo(logger: LearningLogger) {
    val topic = "topic02/inline-reified"
    val values: List<Any> = listOf("Kotlin", 42, "Compose", true)

    logger.info(topic, "strings=${values.onlyOfType<String>()}")
    runAround(
        before = { logger.debug(topic, "before inline callback") },
        block = { logger.info(topic, "inside inline block") },
    )

    /*
    Wrong:
    fun <T> List<Any>.onlyOfTypeWrong(): List<T> = filterIsInstance<T>()

    Why wrong:
    Non-reified `T` is erased at runtime. `filterIsInstance<T>()` needs a reified
    type parameter supplied by an inline function.
    */
}

private inline fun runAround(
    before: () -> Unit,
    block: () -> Unit,
) {
    before()
    block()
}

private inline fun <reified T> List<Any>.onlyOfType(): List<T> = filterIsInstance<T>()
