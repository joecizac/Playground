package com.jozze.playground.topic10_mvi

import com.jozze.playground.core.logging.LearningLogger

/**
 * MVVM vs MVI.
 *
 * MVVM is usually lighter and flexible. MVI is stricter: one state model, clear
 * intents, pure reducers, and explicit effects. The tradeoff is more boilerplate.
 */
fun runMvvmVsMviDemo(logger: LearningLogger) {
    val topic = "topic10/mvvm-vs-mvi"
    logger.info(topic, "MVVM: less ceremony, good for straightforward state.")
    logger.info(topic, "MVI: stricter state transitions, good for complex screens.")

    /*
    Wrong:
    Choosing MVI only because it sounds more advanced.

    Why wrong:
    Architecture should match complexity. MVI boilerplate is justified when it
    improves traceability and prevents state bugs.
    */
}
