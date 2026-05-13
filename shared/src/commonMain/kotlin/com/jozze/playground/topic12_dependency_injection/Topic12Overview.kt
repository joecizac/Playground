package com.jozze.playground.topic12_dependency_injection

import com.jozze.playground.core.catalog.logTopicOverview
import com.jozze.playground.core.logging.LearningLogger

/** Phase 0 entry point for dependency injection examples. */
fun runTopic12OverviewDemo(logger: LearningLogger) {
    logTopicOverview(logger, "topic12", "Dependency Injection", "Add IoC, dependency inversion, DI vs service locator, Koin, and Hilt/Dagger comparison examples.")
}
