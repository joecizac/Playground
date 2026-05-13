package com.jozze.playground.topic13_design_patterns

import com.jozze.playground.core.logging.LearningLogger

/**
 * Adapter pattern.
 *
 * An adapter converts one interface into another expected by the client.
 */
fun runAdapterPatternDemo(logger: LearningLogger) {
    val topic = "topic13/adapter"
    val renderer: NoteRenderer = MarkdownNoteAdapter(LegacyMarkdownNote("# Adapter"))
    logger.info(topic, renderer.renderPlainText())

    /*
    Wrong:
    Passing LegacyMarkdownNote through every layer and checking markdown syntax everywhere.

    Why wrong:
    Client code becomes coupled to an incompatible representation. Adapt at the
    boundary and expose the interface the client needs.
    */
}

private interface NoteRenderer {
    fun renderPlainText(): String
}

private data class LegacyMarkdownNote(val rawMarkdown: String)

private class MarkdownNoteAdapter(
    private val legacy: LegacyMarkdownNote,
) : NoteRenderer {
    override fun renderPlainText(): String = legacy.rawMarkdown.removePrefix("# ").trim()
}
