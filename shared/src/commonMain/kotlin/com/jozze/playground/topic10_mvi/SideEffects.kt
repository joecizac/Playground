package com.jozze.playground.topic10_mvi

import com.jozze.playground.core.logging.LearningLogger

/**
 * Handling side effects.
 *
 * Effects describe work that must happen outside the reducer, such as navigation
 * or loading data. An effect handler executes the work and feeds results back as
 * new intents or messages.
 */
fun runMviSideEffectsDemo(logger: LearningLogger) {
    val topic = "topic10/effects"
    val effect = reducePracticeNotes(PracticeNotesMviState(), PracticeNotesIntent.NoteClicked("n1"))
        .effects
        .single()

    logger.info(topic, "effect to handle=$effect")

    /*
    Wrong:
    state.copy(navigateTo = "n1")

    Why risky:
    Navigation is an effect, not durable state. Keeping it in state can replay it
    after recreation unless carefully consumed.
    */
}
