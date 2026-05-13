package com.jozze.playground.topic13_design_patterns

import com.jozze.playground.core.logging.LearningLogger

/**
 * Facade pattern.
 *
 * A facade provides a simpler API over multiple collaborating objects.
 */
fun runFacadePatternDemo(logger: LearningLogger) {
    val topic = "topic13/facade"
    val facade = PracticeSessionFacade(TopicLoader(), ProgressRecorder())
    logger.info(topic, facade.startSession("Architecture"))

    /*
    Wrong:
    screen.topicLoader.load(); screen.progressRecorder.start(); screen.analytics.track()

    Why wrong:
    The screen coordinates subsystem details. A facade can expose the one action
    the screen actually needs.
    */
}

private class TopicLoader {
    fun load(topic: String): String = "Loaded $topic"
}

private class ProgressRecorder {
    fun start(topic: String): String = "Started progress for $topic"
}

private class PracticeSessionFacade(
    private val loader: TopicLoader,
    private val recorder: ProgressRecorder,
) {
    fun startSession(topic: String): String = "${loader.load(topic)}; ${recorder.start(topic)}"
}
