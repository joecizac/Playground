# Local Codex Instructions

This repository is a local-only Kotlin Android KMP/CMP learning playground. Preserve these project-specific rules when continuing work.

## Execution Model

- Work phase-wise according to `README.md` and `CODEX_HANDOFF.md`.
- Keep changes scoped to the active phase unless the user asks otherwise.
- Run `./gradlew :composeApp:assembleDebug` after implementing a phase.
- Commit phase work when the user asks.
- There is currently no Git remote; do not assume push is possible.

## Source Structure

- Major topics are numbered packages under `com.jozze.playground`.
- Shared/KMP-safe topics go in `shared/src/commonMain`.
- Android-only topics go in Android source sets or Android-only modules.
- UI-heavy Compose demos can live in `composeApp/src/androidMain`.
- Each topic package should keep a `README.md`.

## Learning Example Rules

- Each subtopic should be a dedicated file, class, interface, or nested package.
- Each subtopic file should include KDoc, right-way code, and commented wrong-way examples with explanations.
- Non-UI subtopics should expose a runner function and log through `LearningLogger`.
- UI subtopics should render the main learning output on screen.
- Keep wrong examples commented so the project compiles.
- Formal tests are deferred until the testing phase unless the user changes that instruction.

## Catalog Rules

- Add new runnable subtopics to `LearningCatalog`.
- Prefer `LearningSubtopic(id, title, summary, isUiFocused, run)` entries for each concrete subtopic.
- Keep placeholder overview runners only for phases not yet implemented.
