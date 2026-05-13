package com.jozze.playground.topic08_clean_architecture

import com.jozze.playground.core.catalog.LearningSubtopic

fun topic08Subtopics(): List<LearningSubtopic> = listOf(
    LearningSubtopic("topic08-dependency-rule", "Dependency Rule", "Logs inward dependencies through a domain use case and repository interface.", false, ::runDependencyRuleDemo),
    LearningSubtopic("topic08-domain-layer", "Domain Layer", "Logs pure entity/use-case behavior.", false, ::runDomainLayerDemo),
    LearningSubtopic("topic08-data-layer", "Data Layer", "Logs DTO/data-source/repository mapping behavior.", false, ::runDataLayerDemo),
    LearningSubtopic("topic08-presentation-layer", "Presentation Layer", "Logs domain-to-UI model conversion.", false, ::runPresentationLayerDemo),
    LearningSubtopic("topic08-repository", "Repository Pattern", "Logs hiding data origin behind a domain interface.", false, ::runRepositoryPatternDemo),
    LearningSubtopic("topic08-mapping", "Data Mapping", "Logs DTO -> Domain -> UI mapping and boundaries.", false, ::runDataMappingDemo),
)
