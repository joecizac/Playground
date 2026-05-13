package com.jozze.playground.topic06_flows

import com.jozze.playground.core.logging.LearningLogger
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking

/**
 * Terminal operators.
 *
 * Terminal operators collect a flow and produce work or a value. Examples are
 * `collect`, `first`, `toList`, `fold`, and `reduce`.
 */
fun runTerminalOperatorsDemo(logger: LearningLogger) = runBlocking {
    val topic = "topic06/terminal"
    val numbers = (1..4).asFlow()

    logger.info(topic, "first=${numbers.first()}")
    logger.info(topic, "toList=${numbers.toList()}")
    logger.info(topic, "fold=${numbers.fold(10) { acc, value -> acc + value }}")
    logger.info(topic, "reduce=${numbers.reduce { acc, value -> acc + value }}")

    /*
    Wrong:
    val value = flow.first()
    // called repeatedly in recomposition

    Why wrong:
    Terminal operators start collection. In UI, collect from lifecycle-aware
    state APIs instead of repeatedly starting collection from rendering code.
    */
}
