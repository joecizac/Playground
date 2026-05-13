# Topic 08: Clean Architecture

## Summary
Separating policy from implementation details through inward dependencies.

## Subtopic Index
- Dependency Rule
- Domain Layer
- Data Layer
- Presentation Layer
- Repository Pattern
- Data Mapping

## Mental Model
Business rules should not know about UI, database, network, or Android framework details.

## Common Mistakes
- Letting DTOs leak into UI.
- Putting Android dependencies in domain code.
- Treating repositories as passive DAO wrappers only.
