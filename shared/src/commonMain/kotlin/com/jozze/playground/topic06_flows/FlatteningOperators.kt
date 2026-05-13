package com.jozze.playground.topic06_flows

import com.jozze.playground.core.logging.LearningLogger
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking

/**
 * Flattening operators.
 *
 * `flatMapConcat` processes inner flows sequentially. `flatMapMerge` collects
 * multiple inner flows concurrently. `flatMapLatest` cancels the previous inner
 * flow when a newer upstream value arrives.
 */
@OptIn(ExperimentalCoroutinesApi::class)
fun runFlatteningOperatorsDemo(logger: LearningLogger) = runBlocking {
    val topic = "topic06/flattening"
    val concat = (1..2).asFlow().flatMapConcat { innerFlow(it) }.toList()
    val merge = (1..2).asFlow().flatMapMerge { innerFlow(it) }.toList()
    val latest = (1..2).asFlow().flatMapLatest { innerFlow(it) }.toList()

    logger.info(topic, "flatMapConcat=$concat")
    logger.info(topic, "flatMapMerge=$merge")
    logger.info(topic, "flatMapLatest=$latest")

    /*
    Wrong:
    searchQueryFlow.flatMapConcat { api.search(it) }

    Why often wrong:
    Search usually wants only the latest query. `flatMapLatest` cancels outdated
    searches and prevents stale results from winning.
    */
}

private fun innerFlow(value: Int) = flow {
    emit("$value-a")
    delay(5)
    emit("$value-b")
}
