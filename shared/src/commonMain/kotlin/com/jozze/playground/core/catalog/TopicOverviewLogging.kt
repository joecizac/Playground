package com.jozze.playground.core.catalog

import com.jozze.playground.core.logging.LearningLogger

/**
 * Shared helper for Phase 0 placeholder runners.
 *
 * The placeholder keeps every topic runnable from the catalog while later phases
 * add detailed subtopic files.
 */
fun logTopicOverview(
    logger: LearningLogger,
    topicId: String,
    topicTitle: String,
    nextStep: String,
) {
    logger.info(topicId, "Running overview for $topicTitle.")
    logger.debug(topicId, "Package is ready. Add subtopic files under this topic package.")
    logger.info(topicId, "Next implementation step: $nextStep")
    logger.warning(topicId, "This is a Phase 0 placeholder, not the final lesson content.")
}
