package com.jozze.playground.topic08_clean_architecture

import com.jozze.playground.core.logging.LearningLogger
import com.jozze.playground.topic08_clean_architecture.practice_notes.InMemoryPracticeNoteDataSource
import com.jozze.playground.topic08_clean_architecture.practice_notes.InMemoryPracticeNoteRepository
import kotlinx.coroutines.runBlocking

/**
 * Data layer.
 *
 * Data implementations own DTOs, data sources, caches, databases, and network
 * clients. They map infrastructure shapes into domain entities.
 */
fun runDataLayerDemo(logger: LearningLogger) = runBlocking {
    val topic = "topic08/data-layer"
    val dataSource = InMemoryPracticeNoteDataSource()
    val repository = InMemoryPracticeNoteRepository(dataSource)

    logger.info(topic, "data source rows=${dataSource.all().size}")
    logger.info(topic, "repository domain notes=${repository.notes().map { it.topic }}")

    /*
    Wrong:
    fun screenState(): List<PracticeNoteDto>

    Why wrong:
    Returning DTOs from data into presentation leaks storage/network shape. Map to
    domain entities at the repository boundary.
    */
}
