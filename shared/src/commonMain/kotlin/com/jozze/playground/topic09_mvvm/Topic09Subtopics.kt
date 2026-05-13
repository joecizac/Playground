package com.jozze.playground.topic09_mvvm

import com.jozze.playground.core.catalog.LearningSubtopic

fun topic09Subtopics(): List<LearningSubtopic> = listOf(
    LearningSubtopic("topic09-core", "Core Components", "Logs Model, View, and ViewModel responsibilities.", false, ::runMvvmCoreComponentsDemo),
    LearningSubtopic("topic09-udf", "Unidirectional Data Flow", "Logs action -> state update flow.", false, ::runMvvmUnidirectionalDataFlowDemo),
    LearningSubtopic("topic09-state", "State Management", "Logs StateFlow as durable UI state.", false, ::runMvvmStateManagementDemo),
    LearningSubtopic("topic09-events", "One-off Events", "Logs SharedFlow for navigation/event delivery.", false, ::runMvvmOneOffEventsDemo),
    LearningSubtopic("topic09-lifecycle", "ViewModel Lifecycle", "Logs owned scope lifetime and cancellation.", false, ::runMvvmViewModelLifecycleDemo),
    LearningSubtopic("topic09-testing-shape", "Testing Shape", "Logs how MVVM will be tested in the final testing phase.", false, ::runMvvmTestingShapeDemo),
)
