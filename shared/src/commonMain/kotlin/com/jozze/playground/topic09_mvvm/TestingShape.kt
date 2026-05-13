package com.jozze.playground.topic09_mvvm

import com.jozze.playground.core.logging.LearningLogger

/**
 * MVVM testing shape.
 *
 * Formal tests are deferred in this project, but the code should be structured
 * for tests: inject use cases, use fake repositories, and assert state emissions.
 */
fun runMvvmTestingShapeDemo(logger: LearningLogger) {
    val topic = "topic09/testing-shape"
    logger.info(topic, "Arrange fake repository -> Act by sending action -> Assert StateFlow emissions")

    /*
    Wrong:
    Test the Compose screen by waiting for a real network request.

    Why wrong:
    UI tests become slow and flaky. Test ViewModel state with fakes, then keep UI
    tests focused on rendering and interactions.
    */
}
