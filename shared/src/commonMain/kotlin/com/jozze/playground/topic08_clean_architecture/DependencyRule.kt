package com.jozze.playground.topic08_clean_architecture

import com.jozze.playground.core.logging.LearningLogger
import com.jozze.playground.topic08_clean_architecture.practice_notes.GetPracticeNotesUseCase
import com.jozze.playground.topic08_clean_architecture.practice_notes.InMemoryPracticeNoteDataSource
import com.jozze.playground.topic08_clean_architecture.practice_notes.InMemoryPracticeNoteRepository
import kotlinx.coroutines.runBlocking

/**
 * Dependency Rule.
 *
 * Source dependencies should point inward: presentation and data can depend on
 * domain abstractions, but domain must not depend on UI, database, network, or
 * Android framework APIs.
 */
fun runDependencyRuleDemo(logger: LearningLogger) = runBlocking {
    val topic = "topic08/dependency-rule"
    val repository = InMemoryPracticeNoteRepository(InMemoryPracticeNoteDataSource())
    val useCase = GetPracticeNotesUseCase(repository)

    logger.info(topic, "domain use case sees ${useCase().size} notes through a repository interface")
    logger.debug(topic, "Data implementation is replaceable because the use case depends on PracticeNoteRepository.")

    /*
    Wrong:
    class GetPracticeNotesUseCase(private val dao: RoomPracticeNoteDao)

    Why wrong:
    Domain policy now depends on an Android/database detail. Depend on a domain
    repository interface and keep Room in the data layer.
    */
}
