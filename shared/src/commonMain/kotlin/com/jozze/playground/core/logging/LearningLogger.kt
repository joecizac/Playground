package com.jozze.playground.core.logging

/**
 * Common logging boundary for learning examples.
 *
 * Shared/KMP-safe demos depend on this interface instead of Android's `Log` API.
 * Android supplies a Logcat implementation in the app module, while other targets
 * can later provide their own implementation.
 */
interface LearningLogger {
    fun debug(topic: String, message: String)
    fun info(topic: String, message: String)
    fun warning(topic: String, message: String)
    fun error(topic: String, message: String, throwable: Throwable? = null)
}
