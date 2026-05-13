package com.jozze.playground.topic06_flows

import com.jozze.playground.core.catalog.logTopicOverview
import com.jozze.playground.core.logging.LearningLogger

/** Phase 0 entry point for Flow examples. */
fun runTopic06OverviewDemo(logger: LearningLogger) {
    logTopicOverview(logger, "topic06", "Flows", "Add cold/hot stream, builder, operator, flowOn, catch, StateFlow, SharedFlow, stateIn, and shareIn demos.")
}
