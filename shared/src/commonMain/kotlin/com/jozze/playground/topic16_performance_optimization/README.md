# Topic 16: Performance Optimization

## Summary
Finding and fixing memory, rendering, and startup problems.

## Subtopic Index
- Memory
- Compose Rendering
- App Startup
- Baseline Profiles
- Macrobenchmark

## Mental Model
Measure first, then optimize the bottleneck that matters to users.

## Common Mistakes
- Optimizing without a baseline measurement.
- Causing broad recomposition with unstable state.
- Holding references that outlive their lifecycle.
