package com.jozze.playground.topic01_kotlin_basics

import com.jozze.playground.core.logging.LearningLogger

/**
 * Collections basics.
 *
 * `List`, `Set`, and `Map` expose read-only APIs. Mutable variants expose
 * mutation operations. Read-only does not always mean deeply immutable.
 */
fun runCollectionsBasicsDemo(logger: LearningLogger) {
    val topic = "topic01/collections"
    val lessons: List<String> = listOf("Kotlin", "Compose", "KMP")
    val uniqueTags: Set<String> = setOf("kotlin", "android", "kotlin")
    val progress: MutableMap<String, Int> = mutableMapOf("Kotlin" to 60)
    progress["Compose"] = 20

    logger.info(topic, "lessons=$lessons")
    logger.info(topic, "uniqueTags=$uniqueTags progress=$progress")

    /*
    Wrong:
    fun exposeCache(): MutableMap<String, Int> = internalCache

    Why wrong:
    Returning mutable collections exposes internal state. Return a read-only
    view or a copy unless callers are supposed to mutate it.
    */
}
