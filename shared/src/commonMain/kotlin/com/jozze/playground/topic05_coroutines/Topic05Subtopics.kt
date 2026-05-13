package com.jozze.playground.topic05_coroutines

import com.jozze.playground.core.catalog.LearningSubtopic

fun topic05Subtopics(): List<LearningSubtopic> = listOf(
    LearningSubtopic("topic05-builders", "Builders", "Logs launch, async, and runBlocking behavior.", false, ::runCoroutineBuildersDemo),
    LearningSubtopic("topic05-dispatchers", "Dispatchers", "Logs Default dispatcher usage and context switching.", false, ::runDispatchersDemo),
    LearningSubtopic("topic05-suspend-functions", "Suspend Functions", "Logs a suspending call and explains continuation-style execution.", false, ::runSuspendFunctionsDemo),
    LearningSubtopic("topic05-job-deferred", "Job & Deferred", "Logs lifecycle-only Job behavior versus Deferred values.", false, ::runJobAndDeferredDemo),
    LearningSubtopic("topic05-context-scope", "Coroutine Context & Scope", "Logs context elements and owned scope cancellation.", false, ::runCoroutineContextAndScopeDemo),
    LearningSubtopic("topic05-structured-concurrency", "Structured Concurrency", "Logs parent-child waiting and composed child results.", false, ::runStructuredConcurrencyDemo),
    LearningSubtopic("topic05-cancellation", "Cancellation", "Logs cooperative cancellation, isActive, yield, and CancellationException handling.", false, ::runCancellationDemo),
    LearningSubtopic("topic05-exceptions", "Exception Handling", "Logs CoroutineExceptionHandler, async await failures, supervisorScope, and coroutineScope.", false, ::runCoroutineExceptionHandlingDemo),
    LearningSubtopic("topic05-channels", "Channels", "Logs buffered channel send/receive and select over ready channels.", false, ::runChannelsDemo),
)
