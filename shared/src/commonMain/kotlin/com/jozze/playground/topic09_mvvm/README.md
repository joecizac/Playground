# Topic 09: MVVM

## Summary
UI state management with ViewModel-owned state and unidirectional data flow.

## Subtopic Index
- Model
- View
- ViewModel
- UDF
- State Management
- One-Off Events
- ViewModel Lifecycle
- Testing Shape

## Mental Model
The View renders state and sends actions; the ViewModel coordinates state transitions.

## Common Mistakes
- Exposing mutable state to the UI.
- Modeling durable state as one-off events.
- Triggering navigation repeatedly after configuration changes.
