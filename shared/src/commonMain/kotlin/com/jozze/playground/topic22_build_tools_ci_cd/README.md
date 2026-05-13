# Topic 22: Build Tools & CI/CD

## Summary
Build configuration, optimization, automation, and release tooling.

## Subtopic Index
- Gradle
- Version Catalogs
- Convention Plugins
- R8 / ProGuard
- CI/CD Pipeline
- Fastlane

## Mental Model
Build tooling should make correct local and CI behavior repeatable.

## Common Mistakes
- Duplicating Gradle configuration across modules.
- Letting CI run different checks than local development.
- Adding release automation before build inputs are stable.
