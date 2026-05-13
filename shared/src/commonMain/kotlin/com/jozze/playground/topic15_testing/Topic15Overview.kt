package com.jozze.playground.topic15_testing

import com.jozze.playground.core.catalog.logTopicOverview
import com.jozze.playground.core.logging.LearningLogger

/** Phase 0 entry point for testing examples; full tests are intentionally deferred. */
fun runTopic15OverviewDemo(logger: LearningLogger) {
    logTopicOverview(logger, "topic15", "Testing", "Add formal tests last: unit, coroutine, Flow, ViewModel, Compose UI, and selected Android tests.")
}
