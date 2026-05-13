package com.jozze.playground.topic13_design_patterns

import com.jozze.playground.core.catalog.LearningSubtopic

fun topic13Subtopics(): List<LearningSubtopic> = listOf(
    LearningSubtopic("topic13-singleton", "Singleton", "Logs Kotlin object singleton behavior and cautions.", false, ::runSingletonPatternDemo),
    LearningSubtopic("topic13-builder", "Builder", "Logs staged object construction.", false, ::runBuilderPatternDemo),
    LearningSubtopic("topic13-factory", "Factory Method", "Logs centralized object creation.", false, ::runFactoryMethodPatternDemo),
    LearningSubtopic("topic13-adapter", "Adapter", "Logs adapting legacy markdown into a renderer interface.", false, ::runAdapterPatternDemo),
    LearningSubtopic("topic13-decorator", "Decorator", "Logs wrapper and extension-based decoration.", false, ::runDecoratorPatternDemo),
    LearningSubtopic("topic13-facade", "Facade", "Logs simplified API over collaborators.", false, ::runFacadePatternDemo),
    LearningSubtopic("topic13-observer", "Observer", "Logs StateFlow as an observer-style primitive.", false, ::runObserverPatternDemo),
    LearningSubtopic("topic13-strategy", "Strategy", "Logs interchangeable algorithm selection.", false, ::runStrategyPatternDemo),
    LearningSubtopic("topic13-command", "Command", "Logs sealed command handling.", false, ::runCommandPatternDemo),
)
