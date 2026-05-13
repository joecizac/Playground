package com.jozze.playground.topic01_kotlin_basics

import com.jozze.playground.core.logging.LearningLogger

/**
 * Interfaces.
 *
 * Classes can implement multiple interfaces. Interfaces may include default
 * implementations but cannot hold constructor state.
 */
fun runInterfacesDemo(logger: LearningLogger) {
    val topic = "topic01/interfaces"
    val item = DownloadableArticle("KMP Guide")

    logger.info(topic, item.render())
    logger.info(topic, item.downloadLabel())

    /*
    Wrong:
    interface UserRepositoryImpl

    Why wrong:
    Interfaces should describe capabilities, not implementation details. Naming
    an interface as an implementation confuses the dependency boundary.
    */
}

private interface Renderable {
    fun render(): String
}

private interface Downloadable {
    fun downloadLabel(): String = "Download available"
}

private class DownloadableArticle(private val title: String) : Renderable, Downloadable {
    override fun render(): String = "Article: $title"
}
