# Topic 06: Flows

## Summary
Cold and hot asynchronous streams in Kotlin.

## Subtopic Index
- Core Concepts
- Builders
- Intermediate Operators
- Flattening Operators
- Combining Operators
- Terminal Operators
- Context Preservation
- Exception Handling
- StateFlow & SharedFlow
- `stateIn` and `shareIn`

## Mental Model
Cold flows describe work; hot flows represent ongoing state or events.

## Common Mistakes
- Expecting a cold flow to run without collection.
- Using `SharedFlow` for durable state.
- Changing dispatcher in collectors instead of using `flowOn` where appropriate.
