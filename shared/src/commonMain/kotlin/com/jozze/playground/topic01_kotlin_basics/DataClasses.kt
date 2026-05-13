package com.jozze.playground.topic01_kotlin_basics

import com.jozze.playground.core.logging.LearningLogger

/**
 * Data classes.
 *
 * Data classes generate `equals`, `hashCode`, `toString`, `copy`, and
 * `componentN` functions for primary-constructor properties.
 */
fun runDataClassesDemo(logger: LearningLogger) {
    val topic = "topic01/data-classes"
    val original = UserProfile(id = "u1", name = "Ada")
    val renamed = original.copy(name = "Ada Lovelace")
    val (id, name) = renamed

    logger.info(topic, "original=$original renamed=$renamed")
    logger.info(topic, "destructured id=$id name=$name equals=${original == renamed}")

    /*
    Wrong:
    data class Session(val id: String) { var token: String = "" }

    Why wrong:
    Properties outside the primary constructor are not included in generated
    equality/copy/component functions, which can surprise callers.
    */
}

private data class UserProfile(
    val id: String,
    val name: String,
)
