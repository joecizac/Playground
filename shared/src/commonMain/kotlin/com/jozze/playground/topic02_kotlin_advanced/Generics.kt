package com.jozze.playground.topic02_kotlin_advanced

import com.jozze.playground.core.logging.LearningLogger

/**
 * Generics and variance.
 *
 * `out` means a type produces values and can be read covariantly. `in` means a
 * type consumes values and can be written contravariantly. Invariant types are
 * safer when both reading and writing are required.
 */
fun runGenericsDemo(logger: LearningLogger) {
    val topic = "topic02/generics"
    val stringBox: ReadOnlyBox<String> = ReadOnlyBox("Kotlin")
    val anyBox: ReadOnlyBox<Any> = stringBox
    val printer: Sink<String> = AnySink()

    printer.accept("variance")
    logger.info(topic, "out covariance read=${anyBox.value}")
    logger.info(topic, "generic function=${firstOrNull(listOf(1, 2, 3))}")

    /*
    Wrong:
    class MutableBox<out T>(var value: T)

    Why wrong:
    `out T` cannot be used in a mutable setter position. A producer-only type can
    be covariant; a read/write mutable box should usually stay invariant.
    */
}

private class ReadOnlyBox<out T>(val value: T)

private interface Sink<in T> {
    fun accept(value: T)
}

private class AnySink : Sink<Any> {
    override fun accept(value: Any) = Unit
}

private fun <T> firstOrNull(values: List<T>): T? = values.firstOrNull()
