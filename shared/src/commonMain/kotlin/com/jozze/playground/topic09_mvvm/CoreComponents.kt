package com.jozze.playground.topic09_mvvm

import com.jozze.playground.core.logging.LearningLogger

/**
 * MVVM core components.
 *
 * Model owns data/business behavior, View renders UI, and ViewModel exposes UI
 * state plus actions without holding direct view references.
 */
fun runMvvmCoreComponentsDemo(logger: LearningLogger) {
    val topic = "topic09/core"
    logger.info(topic, "Model=data/use cases, View=renderer, ViewModel=state holder and action coordinator")

    /*
    Wrong:
    class NotesViewModel(private val textView: TextView)

    Why wrong:
    ViewModels should not hold concrete View references. Expose state and let the
    View render it.
    */
}
