package com.jozze.playground.topic07_jetpack_compose

import com.jozze.playground.core.catalog.LearningSubtopic
import com.jozze.playground.core.logging.LearningLogger

fun topic07Subtopics(): List<LearningSubtopic> = listOf(
    LearningSubtopic("topic07-mental-model", "Mental Model", "Shows declarative UI and unidirectional data flow.", true, ::logComposeSubtopicSelection),
    LearningSubtopic("topic07-state", "State Management", "Shows remember, rememberSaveable, and mutableStateOf.", true, ::logComposeSubtopicSelection),
    LearningSubtopic("topic07-layouts", "Layouts", "Shows Column, Row, Box, and Scaffold-style structure.", true, ::logComposeSubtopicSelection),
    LearningSubtopic("topic07-lists", "Lists", "Shows LazyColumn and stable item keys.", true, ::logComposeSubtopicSelection),
    LearningSubtopic("topic07-modifiers", "Modifiers", "Shows why modifier order changes behavior.", true, ::logComposeSubtopicSelection),
    LearningSubtopic("topic07-side-effects", "Side Effects", "Shows LaunchedEffect, rememberCoroutineScope, DisposableEffect, SideEffect, produceState, and derivedStateOf.", true, ::logComposeSubtopicSelection),
    LearningSubtopic("topic07-composition-local", "CompositionLocal", "Shows implicit value propagation through the composition tree.", true, ::logComposeSubtopicSelection),
    LearningSubtopic("topic07-theming", "Theming", "Shows MaterialTheme typography, color, and shape usage.", true, ::logComposeSubtopicSelection),
)

private fun logComposeSubtopicSelection(logger: LearningLogger) {
    logger.info("topic07/compose", "A Compose UI subtopic was selected. The learning output is rendered on screen.")
}
