package com.jozze.playground.topic10_mvi

import com.jozze.playground.core.logging.LearningLogger

/**
 * MVI core concepts.
 *
 * MVI uses Intent for user actions, Model/State as the single source of truth,
 * and View as a renderer of immutable state.
 */
fun runMviCoreConceptsDemo(logger: LearningLogger) {
    val topic = "topic10/core"
    logger.info(topic, "Intent -> reducer -> State + Effect -> View renders State")

    /*
    Wrong:
    view.showLoading(); repository.load(); view.hideLoading()

    Why wrong:
    The rendered result is spread across imperative calls. MVI keeps rendering
    driven by one immutable state value.
    */
}
