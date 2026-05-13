package com.jozze.playground.topic02_kotlin_advanced

import com.jozze.playground.core.logging.LearningLogger

typealias UserId = String
typealias ScoreFormatter = (Int) -> String

/**
 * Type aliases.
 *
 * A type alias gives another name to an existing type. It improves readability
 * but does not create a new runtime type or stronger type safety.
 */
fun runTypeAliasesDemo(logger: LearningLogger) {
    val topic = "topic02/type-aliases"
    val id: UserId = "user-42"
    val formatter: ScoreFormatter = { score -> "score=$score" }

    logger.info(topic, "id=$id ${formatter(95)}")
    logger.warning(topic, "UserId is still a String; use a value class later when stronger typing is needed.")

    /*
    Wrong:
    typealias Password = String

    Why wrong:
    This may look safer, but any String can still be passed as a Password. Use a
    dedicated value class when the compiler should distinguish the types.
    */
}
