# Topic 05: Coroutines

## Summary
Structured asynchronous programming in Kotlin.

## Subtopic Index
- Builders
- Dispatchers
- Suspend Functions
- Job & Deferred
- Coroutine Context & Scope
- Structured Concurrency
- Cancellation
- Exception Handling
- Channels

## Mental Model
Coroutines are units of asynchronous work with explicit parent-child lifetimes.

## Common Mistakes
- Launching work in `GlobalScope`.
- Swallowing `CancellationException`.
- Blocking threads from suspend functions.
