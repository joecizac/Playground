# Topic 12: Dependency Injection

## Summary
Supplying dependencies from the outside so code is replaceable and testable.

## Subtopic Index
- Inversion of Control
- Dependency Inversion
- DI vs Service Locator
- Hilt / Dagger
- Koin

## Mental Model
Classes declare what they need; composition roots decide how dependencies are built.

## Common Mistakes
- Hiding dependencies behind global accessors.
- Injecting concrete implementations when an interface boundary is needed.
- Using application-wide scope for short-lived dependencies.
