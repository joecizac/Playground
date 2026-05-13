package com.jozze.playground.topic02_kotlin_advanced

import com.jozze.playground.core.logging.LearningLogger

/**
 * Exception handling.
 *
 * Use `try/catch/finally` for recoverable exceptional paths. Prefer typed
 * results for expected domain failures, and custom exceptions for failures that
 * need a specific technical meaning.
 */
fun runExceptionHandlingDemo(logger: LearningLogger) {
    val topic = "topic02/exceptions"
    val parsed = try {
        parsePositiveInt("42")
    } catch (error: InvalidPositiveIntException) {
        logger.error(topic, "Failed to parse number", error)
        0
    } finally {
        logger.debug(topic, "finally runs whether parsing succeeds or fails.")
    }

    logger.info(topic, "parsed=$parsed")

    try {
        parsePositiveInt("-1")
    } catch (error: InvalidPositiveIntException) {
        logger.error(topic, "Custom exception demonstrates an error-level Logcat entry.", error)
    }

    /*
    Wrong:
    catch (error: Throwable) { }

    Why wrong:
    Catching and ignoring everything hides defects and may swallow cancellation
    or serious runtime problems. Catch the specific failure you can handle.
    */
}

private class InvalidPositiveIntException(message: String) : IllegalArgumentException(message)

private fun parsePositiveInt(raw: String): Int {
    val value = raw.toIntOrNull() ?: throw InvalidPositiveIntException("'$raw' is not an Int")
    if (value <= 0) throw InvalidPositiveIntException("$value is not positive")
    return value
}
