package com.jozze.playground.topic06_flows

import com.jozze.playground.core.logging.LearningLogger
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking

/**
 * Flow builders.
 *
 * `flow {}` is best for custom emission logic. `flowOf` creates a flow from
 * fixed values. `asFlow` converts collections, ranges, and other supported
 * values into flows.
 */
fun runFlowBuildersDemo(logger: LearningLogger) = runBlocking {
    val topic = "topic06/builders"
    val custom = flow {
        emit("custom-1")
        emit("custom-2")
    }
    val fixed = flowOf("fixed-1", "fixed-2")
    val fromRange = (1..3).asFlow()

    logger.info(topic, "flow builder=${custom.toList()}")
    logger.info(topic, "flowOf=${fixed.toList()}")
    logger.info(topic, "asFlow=${fromRange.toList()}")

    /*
    Wrong:
    flow {
        launch { emit("from child") }
    }

    Why wrong:
    `flow {}` preserves context and does not allow arbitrary concurrent emits.
    Use `channelFlow` when concurrent producers are required.
    */
}
