package com.jozze.playground.topic10_mvi

import com.jozze.playground.core.logging.LearningLogger

/**
 * Reducer pattern.
 *
 * A reducer is a pure function: previous state plus intent produces next state
 * and optional effects. It should not perform network, database, or clock work.
 */
fun runMviReducerPatternDemo(logger: LearningLogger) {
    val topic = "topic10/reducer"
    val result = reducePracticeNotes(PracticeNotesMviState(), PracticeNotesIntent.LoadClicked)

    logger.info(topic, "next state=${result.state}")
    logger.info(topic, "effects=${result.effects}")

    /*
    Wrong:
    fun reduce(state, intent) {
        val notes = api.loadNotes()
        return state.copy(notes = notes)
    }

    Why wrong:
    Reducers should be deterministic and side-effect free. Return a command or
    effect and execute it outside the reducer.
    */
}
