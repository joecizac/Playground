# Codex Local Handoff

This file preserves the current project context for a future local Codex session on another machine. The project does not rely on Connect Codex, cloud state, or a Git remote, so this repository itself is the source of truth.

## Current State

- Workspace: Kotlin Multiplatform / Compose Multiplatform learning playground.
- Root package: `com.jozze.playground`.
- Android app module: `composeApp`.
- Shared KMP module: `shared`.
- Current branch: `main`.
- Latest known handoff commit: this commit, titled `Add local Codex handoff context`. Run `git log --oneline -1` for the exact hash on the receiving machine.
- Working tree is clean at handoff.
- A Git `origin` remote may be configured, but this handoff assumes no cloud/Connect Codex state is available. Copy the repository or use a Git bundle for fully local transfer.

## What Has Been Implemented

### Phase 0: Foundation
- Git repository initialized.
- Root roadmap and package conventions added in `README.md`.
- Shared `LearningLogger` abstraction added.
- Android Logcat logger added.
- Compose catalog screen added.
- Placeholder packages and topic READMEs added for all 22 topics.

### Phase 1: Kotlin Basics And Kotlin Advanced
- `topic01_kotlin_basics` implemented with documented Logcat demos.
- `topic02_kotlin_advanced` implemented with documented Logcat demos.
- All subtopics are catalog-wired.

### Phase 2: Coroutines And Flows
- `kotlinx-coroutines-core` added to `shared`.
- `topic05_coroutines` implemented.
- `topic06_flows` implemented.
- All subtopics are catalog-wired and log through `LearningLogger`.

### Phase 3: Jetpack Compose
- `topic07_jetpack_compose` implemented as screen-first demos.
- Compose examples live in `composeApp/src/androidMain/kotlin/com/jozze/playground/topic07_jetpack_compose`.
- Shared topic metadata lives in `shared/src/commonMain/kotlin/com/jozze/playground/topic07_jetpack_compose`.

### Phase 4: Architecture, MVVM, MVI, Patterns
- `topic08_clean_architecture` implemented using a shared `practice_notes` sample domain.
- `topic09_mvvm` implemented with StateFlow/SharedFlow examples.
- `topic10_mvi` implemented with intents, reducer, state, and effects.
- `topic13_design_patterns` implemented with common Kotlin/Android-relevant pattern examples.
- All subtopics are catalog-wired.

## Next Phase

Continue with **Phase 5: Modularization And DI**.

Implement:

- `topic11_multi_modular_architecture`
  - why modularize
  - module types
  - dependency graph rules
  - circular dependency avoidance
  - Gradle version catalogs
  - convention plugins
  - cross-module navigation patterns

- `topic12_dependency_injection`
  - Inversion of Control
  - Dependency Inversion
  - DI vs Service Locator
  - Koin-style KMP DI examples
  - Hilt/Dagger Android comparison notes

Recommendation for Phase 5:

- Start with reference examples in `shared/src/commonMain` before creating many real Gradle modules.
- Introduce real modules only when they teach a concrete boundary.
- Keep the app build green after each phase.

## Project Conventions

- Each major topic is a numbered package:
  - `topic01_kotlin_basics`
  - `topic02_kotlin_advanced`
  - ...
  - `topic22_build_tools_ci_cd`
- One subtopic with one concept should be one Kotlin file.
- One subtopic with multiple collaborating types should be a nested package.
- Each topic package should have a `README.md`.
- Each subtopic file should include:
  - KDoc explanation.
  - compiling right-way examples.
  - commented wrong-way examples with explanation.
  - a runnable function such as `runNullSafetyDemo(logger)`.
- Non-UI topics should log through `LearningLogger`.
- UI topics should render visible screen output.
- Formal tests are intentionally deferred until Phase 8.

## Important Files

- `README.md`: roadmap and conventions.
- `AGENTS.md`: persistent local Codex instructions for this repo.
- `shared/src/commonMain/kotlin/com/jozze/playground/core/catalog/LearningCatalog.kt`: topic registry used by the app.
- `shared/src/commonMain/kotlin/com/jozze/playground/core/logging/LearningLogger.kt`: common logging boundary.
- `composeApp/src/androidMain/kotlin/com/jozze/playground/core/logging/AndroidLearningLogger.kt`: Android Logcat implementation.
- `composeApp/src/androidMain/kotlin/com/jozze/playground/App.kt`: catalog UI.

## Validation Command

Use this after each phase:

```shell
./gradlew :composeApp:assembleDebug
```

Last known build validation before handoff:

```text
./gradlew :composeApp:assembleDebug
BUILD SUCCESSFUL
```

## Moving To Another Machine Without Cloud

Preferred options:

1. Copy the full repository folder to the other machine, including the `.git` directory.
2. Or create a Git bundle from this machine:

```shell
git bundle create Playground.bundle --all
```

Then on the new machine:

```shell
git clone Playground.bundle Playground
cd Playground
./gradlew :composeApp:assembleDebug
```

If using a plain zip/archive, include hidden files so `.git`, `.gitignore`, and Gradle wrapper files are preserved.

## Suggested Prompt For The Next Local Codex Session

```text
Read CODEX_HANDOFF.md, AGENTS.md, and README.md. Continue the Kotlin Android KMP CMP Learning Playground from Phase 5. Preserve the existing package conventions, Logcat runner pattern, and deferred-testing strategy. Build with ./gradlew :composeApp:assembleDebug after implementation.
```
