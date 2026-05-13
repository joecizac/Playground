# Topic 07: Jetpack Compose

## Summary
Declarative UI, state, recomposition, layout, effects, and theming.

## Subtopic Index
- Mental Model
- State Management
- Layouts
- Lists
- Modifiers
- Side Effects
- CompositionLocal
- Theming

## Mental Model
UI is a function of state. Events change state; recomposition reflects the new state.

## Common Mistakes
- Mutating non-state objects and expecting recomposition.
- Running side effects directly in composable bodies.
- Ignoring modifier order.
