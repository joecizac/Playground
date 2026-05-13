package com.jozze.playground.topic02_kotlin_advanced

import com.jozze.playground.core.catalog.LearningSubtopic

fun topic02Subtopics(): List<LearningSubtopic> = listOf(
    LearningSubtopic("topic02-extensions", "Extension Functions & Properties", "Logs receiver-based extension behavior and static-resolution cautions.", false, ::runExtensionsDemo),
    LearningSubtopic("topic02-higher-order-functions", "Higher-Order Functions", "Logs functions as parameters and functions returned from functions.", false, ::runHigherOrderFunctionsDemo),
    LearningSubtopic("topic02-lambdas", "Lambdas & Anonymous Functions", "Logs lambda syntax, trailing lambdas, it usage, and anonymous functions.", false, ::runLambdasAndAnonymousFunctionsDemo),
    LearningSubtopic("topic02-scope-functions", "Scope Functions", "Logs let, run, apply, and also usage with receiver/argument guidance.", false, ::runScopeFunctionsDemo),
    LearningSubtopic("topic02-delegation", "Delegation", "Logs lazy, observable properties, and class delegation.", false, ::runDelegationDemo),
    LearningSubtopic("topic02-sealed", "Sealed Classes & Interfaces", "Logs exhaustive state rendering with sealed interfaces.", false, ::runSealedClassesAndInterfacesDemo),
    LearningSubtopic("topic02-generics", "Generics", "Logs type parameters and variance with in/out examples.", false, ::runGenericsDemo),
    LearningSubtopic("topic02-inline-reified", "Inline Functions & Reified Types", "Logs inline callbacks and runtime filtering with reified type parameters.", false, ::runInlineAndReifiedTypesDemo),
    LearningSubtopic("topic02-type-aliases", "Type Aliases", "Logs alternate names for existing types and their limitations.", false, ::runTypeAliasesDemo),
    LearningSubtopic("topic02-objects", "Object Expressions & Declarations", "Logs singleton, anonymous object, and companion object behavior.", false, ::runObjectExpressionsAndDeclarationsDemo),
    LearningSubtopic("topic02-exceptions", "Exception Handling", "Logs try/catch/finally, custom exceptions, and error-level handling.", false, ::runExceptionHandlingDemo),
)
