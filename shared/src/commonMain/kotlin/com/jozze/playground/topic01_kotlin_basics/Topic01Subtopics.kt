package com.jozze.playground.topic01_kotlin_basics

import com.jozze.playground.core.catalog.LearningSubtopic

fun topic01Subtopics(): List<LearningSubtopic> = listOf(
    LearningSubtopic("topic01-variables", "Variables & Data Types", "Logs val vs var, basic types, strings, and arrays.", false, ::runVariablesAndDataTypesDemo),
    LearningSubtopic("topic01-control-flow", "Control Flow", "Logs if/when expressions plus for and while loops.", false, ::runControlFlowDemo),
    LearningSubtopic("topic01-functions", "Functions", "Logs declarations, defaults, named arguments, and single-expression functions.", false, ::runFunctionsDemo),
    LearningSubtopic("topic01-null-safety", "Null Safety", "Logs nullable types, safe calls, Elvis, and explicit checks.", false, ::runNullSafetyDemo),
    LearningSubtopic("topic01-classes", "Classes & Objects", "Logs constructors, properties, custom accessors, and init validation.", false, ::runClassesAndObjectsDemo),
    LearningSubtopic("topic01-visibility", "Visibility Modifiers", "Logs public/private/protected usage through a small model.", false, ::runVisibilityModifiersDemo),
    LearningSubtopic("topic01-inheritance", "Inheritance", "Logs open classes/functions, overriding, and super calls.", false, ::runInheritanceDemo),
    LearningSubtopic("topic01-interfaces", "Interfaces", "Logs multiple interface implementation and default behavior.", false, ::runInterfacesDemo),
    LearningSubtopic("topic01-data-classes", "Data Classes", "Logs generated copy, equality, toString, and destructuring behavior.", false, ::runDataClassesDemo),
    LearningSubtopic("topic01-collections", "Collections", "Logs List, Set, Map, mutable vs read-only collection usage.", false, ::runCollectionsBasicsDemo),
    LearningSubtopic("topic01-sequences", "Sequences", "Logs eager collection operators vs lazy sequence processing.", false, ::runSequencesDemo),
)
