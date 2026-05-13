package com.jozze.playground.core.logging

import android.util.Log

/**
 * Android implementation of [LearningLogger] that writes shared examples to Logcat.
 */
class AndroidLearningLogger : LearningLogger {
    override fun debug(topic: String, message: String) {
        Log.d(tagFor(topic), format(topic, message))
    }

    override fun info(topic: String, message: String) {
        Log.i(tagFor(topic), format(topic, message))
    }

    override fun warning(topic: String, message: String) {
        Log.w(tagFor(topic), format(topic, message))
    }

    override fun error(topic: String, message: String, throwable: Throwable?) {
        Log.e(tagFor(topic), format(topic, message), throwable)
    }

    private fun tagFor(topic: String): String {
        val stableTopic = topic.substringBefore(' ').substringBefore('/').replaceFirstChar { it.uppercase() }
        return "Playground.$stableTopic"
    }

    private fun format(topic: String, message: String): String = "[$topic] $message"
}
