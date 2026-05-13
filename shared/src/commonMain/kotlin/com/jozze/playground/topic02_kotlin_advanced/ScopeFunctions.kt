package com.jozze.playground.topic02_kotlin_advanced

import com.jozze.playground.core.logging.LearningLogger

/**
 * Scope functions.
 *
 * `let` and `also` pass the object as `it`. `run`, `with`, and `apply` expose
 * the object as `this`. Choose based on whether you are transforming, configuring,
 * or adding side effects.
 */
fun runScopeFunctionsDemo(logger: LearningLogger) {
    val topic = "topic02/scope-functions"
    val config = DemoConfig().apply {
        endpoint = "https://example.invalid"
        retries = 2
    }
    val summary = config.run { "$endpoint retries=$retries" }
    val length = summary.let { it.length }

    logger.info(topic, "apply configured=$config")
    logger.info(topic, "run summary=$summary let length=$length")
    logger.info(topic, config.also { logger.debug(topic, "also is good for side effects: $it") }.toString())

    /*
    Wrong:
    user?.let { it.address?.let { it.city?.let { city -> ... } } }

    Why wrong:
    Deep nesting makes receiver meaning hard to follow. Prefer named locals or
    small functions when a chain stops being readable.
    */
}

private data class DemoConfig(
    var endpoint: String = "",
    var retries: Int = 0,
)
