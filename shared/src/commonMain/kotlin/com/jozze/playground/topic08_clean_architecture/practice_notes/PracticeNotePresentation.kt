package com.jozze.playground.topic08_clean_architecture.practice_notes

/**
 * Presentation model for the architecture examples.
 *
 * UI models can flatten, format, or rename domain fields for rendering without
 * changing business entities.
 */
data class PracticeNoteUiModel(
    val id: String,
    val title: String,
    val preview: String,
    val statusLabel: String,
)

fun PracticeNote.toUiModel(): PracticeNoteUiModel = PracticeNoteUiModel(
    id = id.value,
    title = topic,
    preview = body.take(32),
    statusLabel = if (isReviewed) "Reviewed" else "Needs review",
)
