package com.jozze.playground.topic08_clean_architecture

import com.jozze.playground.core.logging.LearningLogger
import com.jozze.playground.topic08_clean_architecture.practice_notes.InMemoryPracticeNoteDataSource
import com.jozze.playground.topic08_clean_architecture.practice_notes.InMemoryPracticeNoteRepository
import kotlinx.coroutines.runBlocking

/**
 * Repository pattern.
 *
 * A repository hides data origin and exposes domain-focused operations. Callers
 * should not care whether data came from memory, database, or network.
 */
fun runRepositoryPatternDemo(logger: LearningLogger) = runBlocking {
    val topic = "topic08/repository"
    val repository = InMemoryPracticeNoteRepository(InMemoryPracticeNoteDataSource())

    logger.info(topic, "topics from repository=${repository.notes().joinToString { it.topic }}")
    logger.debug(topic, "The caller sees PracticeNoteRepository behavior, not data-source mechanics.")

    /*
    Wrong:
    viewModel.remoteApi.getNotes(); viewModel.localDao.insert(...)

    Why wrong:
    The UI layer is coordinating data origins. Put cache/network/database policy
    behind a repository.
    */
}
