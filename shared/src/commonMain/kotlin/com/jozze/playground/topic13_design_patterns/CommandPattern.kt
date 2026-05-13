package com.jozze.playground.topic13_design_patterns

import com.jozze.playground.core.logging.LearningLogger

/**
 * Command pattern.
 *
 * A command represents an action as data or an object. MVI intents are a common
 * Android/Kotlin example of command-like modeling.
 */
fun runCommandPatternDemo(logger: LearningLogger) {
    val topic = "topic13/command"
    val commands = listOf<PracticeCommand>(
        PracticeCommand.AddNote("Architecture"),
        PracticeCommand.MarkReviewed("n1"),
    )

    commands.forEach { command -> logger.info(topic, handle(command)) }

    /*
    Wrong:
    fun handle(action: String, payload: String)

    Why wrong:
    Stringly typed commands are easy to misspell and hard to exhaustively handle.
    Use sealed classes/interfaces for a closed command set.
    */
}

private sealed interface PracticeCommand {
    data class AddNote(val topic: String) : PracticeCommand
    data class MarkReviewed(val id: String) : PracticeCommand
}

private fun handle(command: PracticeCommand): String = when (command) {
    is PracticeCommand.AddNote -> "add note for ${command.topic}"
    is PracticeCommand.MarkReviewed -> "mark ${command.id} reviewed"
}
