package com.jozze.playground.topic06_flows

import com.jozze.playground.core.logging.LearningLogger
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

/**
 * Combining operators.
 *
 * `zip` pairs emissions by index and completes when either flow completes.
 * `combine` emits whenever either upstream emits after both have emitted once.
 */
fun runCombiningOperatorsDemo(logger: LearningLogger) = runBlocking {
    val topic = "topic06/combining"
    val names = flowOf("Ada", "Grace")
    val scores = flowOf(95, 88, 70)

    val zipped = names.zip(scores) { name, score -> "$name=$score" }.toList()
    val combined = flowOf("user").combine(flowOf("online", "away")) { user, status -> "$user:$status" }.toList()

    logger.info(topic, "zip=$zipped")
    logger.info(topic, "combine=$combined")

    /*
    Wrong:
    zip(userFlow, settingsFlow) for UI state that should update whenever either changes.

    Why wrong:
    `zip` waits for paired emissions. UI state usually wants `combine` so any
    relevant upstream change recomputes the screen state.
    */
}
