package com.jozze.playground.topic06_flows

import com.jozze.playground.core.catalog.LearningSubtopic

fun topic06Subtopics(): List<LearningSubtopic> = listOf(
    LearningSubtopic("topic06-core", "Core Concepts", "Logs cold collection behavior and hot SharedFlow replay.", false, ::runFlowCoreConceptsDemo),
    LearningSubtopic("topic06-builders", "Builders", "Logs flow, flowOf, and asFlow builders.", false, ::runFlowBuildersDemo),
    LearningSubtopic("topic06-intermediate", "Intermediate Operators", "Logs map, filter, transform, and take.", false, ::runIntermediateOperatorsDemo),
    LearningSubtopic("topic06-flattening", "Flattening Operators", "Logs flatMapConcat, flatMapMerge, and flatMapLatest.", false, ::runFlatteningOperatorsDemo),
    LearningSubtopic("topic06-combining", "Combining Operators", "Logs zip versus combine behavior.", false, ::runCombiningOperatorsDemo),
    LearningSubtopic("topic06-terminal", "Terminal Operators", "Logs first, toList, fold, and reduce.", false, ::runTerminalOperatorsDemo),
    LearningSubtopic("topic06-context", "Context Preservation", "Logs flowOn and explains context-safe emission.", false, ::runContextPreservationDemo),
    LearningSubtopic("topic06-exceptions", "Exception Handling", "Logs catch recovery and downstream exception transparency.", false, ::runFlowExceptionHandlingDemo),
    LearningSubtopic("topic06-state-shared", "StateFlow & SharedFlow", "Logs latest state and event-style shared emissions.", false, ::runStateFlowAndSharedFlowDemo),
    LearningSubtopic("topic06-stateIn-shareIn", "stateIn & shareIn", "Logs conversion from cold flows to hot StateFlow and SharedFlow.", false, ::runStateInAndShareInDemo),
)
