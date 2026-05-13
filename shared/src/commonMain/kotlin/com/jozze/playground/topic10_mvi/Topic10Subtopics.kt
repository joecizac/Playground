package com.jozze.playground.topic10_mvi

import com.jozze.playground.core.catalog.LearningSubtopic

fun topic10Subtopics(): List<LearningSubtopic> = listOf(
    LearningSubtopic("topic10-core", "Core Concepts", "Logs intent, state/model, and view renderer responsibilities.", false, ::runMviCoreConceptsDemo),
    LearningSubtopic("topic10-reducer", "Reducer Pattern", "Logs pure State + Intent -> State + Effects behavior.", false, ::runMviReducerPatternDemo),
    LearningSubtopic("topic10-effects", "Handling Side Effects", "Logs effect creation for work outside reducers.", false, ::runMviSideEffectsDemo),
    LearningSubtopic("topic10-mvvm-vs-mvi", "MVVM vs MVI", "Logs tradeoffs between flexible MVVM and stricter MVI.", false, ::runMvvmVsMviDemo),
)
