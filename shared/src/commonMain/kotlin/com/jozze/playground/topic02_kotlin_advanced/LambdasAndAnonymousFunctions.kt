package com.jozze.playground.topic02_kotlin_advanced

import com.jozze.playground.core.logging.LearningLogger

/**
 * Lambdas and anonymous functions.
 *
 * Lambdas are concise function literals. Anonymous functions are useful when an
 * explicit return type or `return` behavior improves clarity.
 */
fun runLambdasAndAnonymousFunctionsDemo(logger: LearningLogger) {
    val topic = "topic02/lambdas"
    val names = listOf("Ada", "Linus", "Grace")
    val shortNames = names.filter { it.length <= 4 }
    val formatter = fun(name: String): String {
        return "Learner=$name"
    }

    logger.info(topic, "trailing lambda result=$shortNames")
    logger.info(topic, "anonymous function result=${formatter("Ada")}")

    /*
    Wrong:
    names.map { name -> println(name) }

    Why wrong:
    `map` means transform values. For side effects, use `forEach`; for logging in
    this project, use `LearningLogger`.
    */
}
