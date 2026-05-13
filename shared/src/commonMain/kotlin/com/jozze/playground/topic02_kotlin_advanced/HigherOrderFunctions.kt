package com.jozze.playground.topic02_kotlin_advanced

import com.jozze.playground.core.logging.LearningLogger

/**
 * Higher-order functions.
 *
 * A higher-order function accepts a function as a parameter, returns a function,
 * or both. This is useful for strategies, callbacks, and small pipelines.
 */
fun runHigherOrderFunctionsDemo(logger: LearningLogger) {
    val topic = "topic02/higher-order-functions"
    val transformed = transformScore(21) { it * 2 }
    val addTax = priceFormatter(rate = 0.18)

    logger.info(topic, "transformed=$transformed")
    logger.info(topic, addTax(100.0))

    /*
    Wrong:
    fun calculate(type: String, value: Int): Int = if (type == "double") value * 2 else value

    Why wrong:
    String switches are brittle. Passing behavior as a function is type-safe and
    lets the caller provide the strategy directly.
    */
}

private fun transformScore(score: Int, transform: (Int) -> Int): Int = transform(score)

private fun priceFormatter(rate: Double): (Double) -> String = { price ->
    "price=$price tax=${price * rate}"
}
