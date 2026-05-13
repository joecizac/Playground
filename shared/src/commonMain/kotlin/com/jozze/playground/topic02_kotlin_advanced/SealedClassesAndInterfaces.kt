package com.jozze.playground.topic02_kotlin_advanced

import com.jozze.playground.core.logging.LearningLogger

/**
 * Sealed classes and interfaces.
 *
 * Sealed hierarchies restrict direct implementations, letting `when` expressions
 * be exhaustive without an `else` when all cases are handled.
 */
fun runSealedClassesAndInterfacesDemo(logger: LearningLogger) {
    val topic = "topic02/sealed"
    val states = listOf<LoadState>(LoadState.Loading, LoadState.Success("Profile"), LoadState.Failure("Offline"))

    states.forEach { state ->
        logger.info(topic, render(state))
    }

    /*
    Wrong:
    data class ScreenState(val isLoading: Boolean, val data: String?, val error: String?)

    Why wrong:
    This allows impossible combinations such as loading with data and error at
    the same time. A sealed hierarchy models mutually exclusive states directly.
    */
}

private sealed interface LoadState {
    data object Loading : LoadState
    data class Success(val data: String) : LoadState
    data class Failure(val message: String) : LoadState
}

private fun render(state: LoadState): String = when (state) {
    LoadState.Loading -> "Loading"
    is LoadState.Success -> "Loaded ${state.data}"
    is LoadState.Failure -> "Error ${state.message}"
}
