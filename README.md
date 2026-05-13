# Kotlin Android KMP CMP Learning Playground

This project is a reference learning playground for Kotlin, Android, Kotlin Multiplatform, Compose Multiplatform, architecture, testing, performance, security, networking, storage, Git, and build tooling.

The source tree is the primary study material. The Android app is a runner/viewer that opens topic demos and sends non-UI example output to Logcat.

## Phase Roadmap

### Phase 0: Foundation
- [x] Initialize Git.
- [x] Add package and documentation conventions.
- [x] Add a shared `LearningLogger` abstraction.
- [x] Add an Android Logcat logger implementation.
- [x] Add a Compose catalog screen for browsing and running topic examples.
- [x] Add placeholder packages for all 22 topics.

### Phase 1: Kotlin Basics And Kotlin Advanced
- [x] Implement `topic01_kotlin_basics`.
- [x] Implement `topic02_kotlin_advanced`.
- [x] Log each non-UI subtopic through `LearningLogger`.
- [x] Include right-way and wrong-way examples in comments.

### Phase 2: Coroutines And Flows
- [x] Implement `topic05_coroutines`.
- [x] Implement `topic06_flows`.
- [x] Log coroutine lifecycle, cancellation, exceptions, channels, and flow emissions.

### Phase 3: Jetpack Compose
- [x] Implement `topic07_jetpack_compose` as screen-first demos.
- [x] Show UI-related learning output on screen.

### Phase 4: Architecture, MVVM, MVI, Patterns
- [x] Implement `topic08_clean_architecture`.
- [x] Implement `topic09_mvvm`.
- [x] Implement `topic10_mvi`.
- [x] Implement `topic13_design_patterns`.

### Phase 5: Multi-Modular Architecture And DI
- [ ] Implement `topic11_multi_modular_architecture`.
- [ ] Implement `topic12_dependency_injection`.
- [ ] Introduce real Gradle module boundaries when the lesson needs them.

### Phase 6: Android Platform Topics
- [ ] Implement `topic03_android_basics`.
- [ ] Implement `topic04_android_advanced`.
- [ ] Keep Android-only demos in Android source sets or Android-only modules.

### Phase 7: Networking, Storage, Security, KMP, CMP
- [ ] Implement `topic17_security`.
- [ ] Implement `topic18_networking_api_integration`.
- [ ] Implement `topic19_local_storage_databases`.
- [ ] Implement `topic20_kotlin_multiplatform_specifics`.
- [ ] Implement `topic21_compose_multiplatform_specifics`.

### Phase 8: Git, Testing, Performance, Build Tools, CI/CD
- [ ] Implement `topic14_git`.
- [ ] Implement `topic15_testing`.
- [ ] Implement `topic16_performance_optimization`.
- [ ] Implement `topic22_build_tools_ci_cd`.
- [ ] Add formal tests last, after the reference examples are in place.

## Package Convention

Each major topic is a package under `com.jozze.playground` with a stable numbered prefix:

```text
topic01_kotlin_basics
topic02_kotlin_advanced
topic03_android_basics
...
topic22_build_tools_ci_cd
```

Subtopic rules:

- One subtopic with one concept becomes one Kotlin file.
- One subtopic with multiple collaborating types becomes a nested package.
- Shared/KMP-safe topics live in `shared/src/commonMain`.
- Android-only topics live in Android source sets or Android-only modules.
- Every topic package gets a `README.md`.

## Documentation Convention

Each subtopic file should include:

- KDoc explaining the concept.
- Small compiling right-way examples.
- Commented wrong-way examples with the reason they are wrong.
- A clear runner function, for example `runNullSafetyDemo(logger)`.
- Logcat output for non-UI topics, or visible UI behavior for UI topics.

Wrong examples must remain commented so the project always compiles:

```kotlin
/*
Wrong:
val name: String = null

Why wrong:
String is non-null. Use String? only when null is a meaningful state.
*/
```

## Logging Convention

Shared examples log through `LearningLogger`. Android provides the Logcat implementation.

Non-UI demos should log useful output with stable topic names. UI demos should show their primary result on screen and may log lifecycle or debug details when useful.

## Build

Build the Android app:

```shell
./gradlew :composeApp:assembleDebug
```

Run shared tests when the testing phase begins:

```shell
./gradlew :shared:allTests
```
