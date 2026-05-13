# Topic 10: MVI

## Summary
Strict state modeling with intents, reducers, state, and effects.

## Subtopic Index
- Intent
- Model/State
- View
- Reducer
- Side Effects
- MVVM vs MVI

## Mental Model
State changes should be explicit and reproducible from actions plus previous state.

## Common Mistakes
- Performing network calls inside reducers.
- Splitting state into conflicting sources of truth.
- Adding MVI boilerplate when a simpler MVVM flow is enough.
