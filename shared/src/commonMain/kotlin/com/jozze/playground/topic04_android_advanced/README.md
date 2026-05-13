# Topic 04: Android Advanced

## Summary
Android system APIs for background work, IPC, custom drawing, and deeper platform behavior.

## Subtopic Index
- WorkManager
- Services
- Broadcast Receivers
- Content Providers
- Handlers, Loopers, Message Queues
- Custom Views
- WindowInsets
- Picture-in-Picture
- IPC

## Mental Model
Use the platform primitive that matches lifecycle, user visibility, and execution constraints.

## Common Mistakes
- Using a foreground service for deferrable work.
- Doing heavy work on the main thread.
- Ignoring edge-to-edge and keyboard insets.
