# Topic 18: Networking / API Integration

## Summary
Calling and modeling remote APIs across Android and KMP.

## Subtopic Index
- REST
- GraphQL
- WebSockets
- OkHttp
- Retrofit
- Ktor Client
- Serialization

## Mental Model
Networking code should separate transport, DTOs, mapping, errors, and domain behavior.

## Common Mistakes
- Returning raw DTOs from domain APIs.
- Ignoring timeout and retry policy.
- Logging sensitive headers or bodies.
