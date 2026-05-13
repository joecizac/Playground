package com.jozze.playground.topic06_flows

import com.jozze.playground.core.logging.LearningLogger
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

/**
 * Intermediate operators.
 *
 * Intermediate operators such as `map`, `filter`, `transform`, and `take`
 * return a new flow. They do not run until a terminal operator collects them.
 */
fun runIntermediateOperatorsDemo(logger: LearningLogger) = runBlocking {
    val topic = "topic06/intermediate"
    val result = (1..6).asFlow()
        .map { it * 2 }
        .filter { it % 3 != 0 }
        .transform {
            emit("value=$it")
            if (it > 6) emit("large=$it")
        }
        .take(4)
        .toList()

    logger.info(topic, "result=$result")

    /*
    Wrong:
    val transformed = flow.map { saveToDatabase(it) }

    Why wrong:
    `map` communicates value transformation. Use `onEach` for side effects or
    keep persistence in a repository layer where the side effect is explicit.
    */
}
