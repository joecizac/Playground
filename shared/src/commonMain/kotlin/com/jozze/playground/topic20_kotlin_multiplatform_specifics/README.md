# Topic 20: Kotlin Multiplatform Specifics

## Summary
Sharing Kotlin code across platforms while preserving platform-specific capabilities.

## Subtopic Index
- Project Structure
- Source Sets
- `expect` / `actual`
- Platform Interfaces
- iOS Interop
- Coroutines & Flows on iOS
- Kotlin/Native Memory Manager

## Mental Model
Common code owns shared policy; platform code owns platform-specific detail.

## Common Mistakes
- Forcing platform APIs into common code.
- Using `expect/actual` when a simple interface would be clearer.
- Ignoring Swift-facing API ergonomics.
