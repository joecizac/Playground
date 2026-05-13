package com.jozze.playground.topic13_design_patterns

import com.jozze.playground.core.logging.LearningLogger

/**
 * Builder pattern.
 *
 * Builders help when object creation has optional values or readable staged
 * configuration. Prefer data-class constructors when creation is simple.
 */
fun runBuilderPatternDemo(logger: LearningLogger) {
    val topic = "topic13/builder"
    val note = PracticeNoteDraftBuilder()
        .topic("Patterns")
        .body("Builder is useful for readable optional configuration.")
        .reviewed()
        .build()

    logger.info(topic, "draft=$note")

    /*
    Wrong:
    Builder for data class User(val id: String, val name: String)

    Why wrong:
    A two-field immutable type is clearer with a constructor or named arguments.
    Builders are most useful when construction has real complexity.
    */
}

private class PracticeNoteDraftBuilder {
    private var topic: String = "Untitled"
    private var body: String = ""
    private var reviewed: Boolean = false

    fun topic(value: String) = apply { topic = value }
    fun body(value: String) = apply { body = value }
    fun reviewed() = apply { reviewed = true }
    fun build(): PracticeNoteDraft = PracticeNoteDraft(topic, body, reviewed)
}

private data class PracticeNoteDraft(
    val topic: String,
    val body: String,
    val reviewed: Boolean,
)
