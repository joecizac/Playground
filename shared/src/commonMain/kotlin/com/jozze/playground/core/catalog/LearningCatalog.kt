package com.jozze.playground.core.catalog

import com.jozze.playground.core.logging.LearningLogger
import com.jozze.playground.topic01_kotlin_basics.topic01Subtopics
import com.jozze.playground.topic02_kotlin_advanced.topic02Subtopics
import com.jozze.playground.topic03_android_basics.runTopic03OverviewDemo
import com.jozze.playground.topic04_android_advanced.runTopic04OverviewDemo
import com.jozze.playground.topic05_coroutines.topic05Subtopics
import com.jozze.playground.topic06_flows.topic06Subtopics
import com.jozze.playground.topic07_jetpack_compose.topic07Subtopics
import com.jozze.playground.topic08_clean_architecture.topic08Subtopics
import com.jozze.playground.topic09_mvvm.topic09Subtopics
import com.jozze.playground.topic10_mvi.topic10Subtopics
import com.jozze.playground.topic11_multi_modular_architecture.runTopic11OverviewDemo
import com.jozze.playground.topic12_dependency_injection.runTopic12OverviewDemo
import com.jozze.playground.topic13_design_patterns.topic13Subtopics
import com.jozze.playground.topic14_git.runTopic14OverviewDemo
import com.jozze.playground.topic15_testing.runTopic15OverviewDemo
import com.jozze.playground.topic16_performance_optimization.runTopic16OverviewDemo
import com.jozze.playground.topic17_security.runTopic17OverviewDemo
import com.jozze.playground.topic18_networking_api_integration.runTopic18OverviewDemo
import com.jozze.playground.topic19_local_storage_databases.runTopic19OverviewDemo
import com.jozze.playground.topic20_kotlin_multiplatform_specifics.runTopic20OverviewDemo
import com.jozze.playground.topic21_compose_multiplatform_specifics.runTopic21OverviewDemo
import com.jozze.playground.topic22_build_tools_ci_cd.runTopic22OverviewDemo

/**
 * Registry used by the Android catalog screen to expose runnable learning entries.
 *
 * Each entry starts as a topic overview runner. Later phases replace or supplement
 * these overviews with subtopic-specific runners such as `runNullSafetyDemo`.
 */
object LearningCatalog {
    val topics: List<LearningTopic> = listOf(
        topic("topic01", "Kotlin Basics", "Variables, control flow, functions, null safety, classes, inheritance, interfaces, collections, and sequences.", "Shared", topic01Subtopics()),
        topic("topic02", "Kotlin Advanced", "Extensions, higher-order functions, lambdas, scope functions, delegation, sealed types, generics, inline/reified, aliases, objects, and exceptions.", "Shared", topic02Subtopics()),
        topic("topic03", "Android Basics", "Lifecycle, context, intents, manifest, resources, permissions, legacy UI, RecyclerView, and ConstraintLayout.", "Android", ::runTopic03OverviewDemo),
        topic("topic04", "Android Advanced", "WorkManager, services, receivers, providers, handlers, custom views, insets, PiP, and IPC.", "Android", ::runTopic04OverviewDemo),
        topic("topic05", "Coroutines", "Builders, dispatchers, suspend functions, jobs, scopes, structured concurrency, cancellation, exceptions, and channels.", "Shared", topic05Subtopics()),
        topic("topic06", "Flows", "Cold and hot streams, builders, operators, context preservation, exception handling, StateFlow, SharedFlow, stateIn, and shareIn.", "Shared", topic06Subtopics()),
        topic("topic07", "Jetpack Compose", "Declarative UI, UDF, recomposition, state, layouts, lists, modifiers, side effects, CompositionLocal, and theming.", "UI", topic07Subtopics()),
        topic("topic08", "Clean Architecture", "Dependency rule, domain/data/presentation layers, repositories, and data mapping.", "Shared", topic08Subtopics()),
        topic("topic09", "MVVM", "Model, View, ViewModel, UDF, StateFlow, one-off events, lifecycle, and testing shape.", "Shared", topic09Subtopics()),
        topic("topic10", "MVI", "Intent, model/state, renderer, reducer, side effects, and MVVM comparison.", "Shared", topic10Subtopics()),
        topic("topic11", "Multi-Modular Architecture", "Module types, dependency graphs, Gradle management, and cross-module navigation.", "Build", ::runTopic11OverviewDemo),
        topic("topic12", "Dependency Injection", "IoC, dependency inversion, DI vs service locator, Koin, and Hilt/Dagger comparisons.", "Shared", ::runTopic12OverviewDemo),
        topic("topic13", "Design Patterns", "Creational, structural, and behavioral patterns in Kotlin and Android code.", "Shared", topic13Subtopics()),
        topic("topic14", "Git", "Commands, branching, merging, rebasing, cherry-pick, stash, reset, revert, and workflows.", "Tooling", ::runTopic14OverviewDemo),
        topic("topic15", "Testing", "Testing pyramid, unit tests, doubles, coroutine/Flow tests, UI tests, and TDD.", "Testing", ::runTopic15OverviewDemo),
        topic("topic16", "Performance Optimization", "Memory, Compose rendering, app startup, baseline profiles, and macrobenchmarking.", "Android", ::runTopic16OverviewDemo),
        topic("topic17", "Security", "Keystore, encrypted storage, TLS, pinning, secret management, obfuscation, and biometrics.", "Android", ::runTopic17OverviewDemo),
        topic("topic18", "Networking / API Integration", "REST, GraphQL, WebSockets, OkHttp, Retrofit, Ktor Client, and serialization.", "Shared", ::runTopic18OverviewDemo),
        topic("topic19", "Local Storage / Databases", "Room, SQLDelight, DataStore, Multiplatform Settings, file system, and scoped storage.", "Shared", ::runTopic19OverviewDemo),
        topic("topic20", "Kotlin Multiplatform Specifics", "Source sets, expect/actual, iOS interop, coroutines/flows on iOS, and Kotlin/Native memory.", "Shared", ::runTopic20OverviewDemo),
        topic("topic21", "Compose Multiplatform Specifics", "Shared UI vs shared logic, platform views, resources, navigation, and lifecycle.", "UI", ::runTopic21OverviewDemo, isUiFocused = true),
        topic("topic22", "Build Tools & CI/CD", "Gradle, version catalogs, convention plugins, R8/ProGuard, CI/CD, and Fastlane.", "Build", ::runTopic22OverviewDemo),
    )

    private fun topic(
        id: String,
        title: String,
        summary: String,
        category: String,
        runner: (LearningLogger) -> Unit,
        isUiFocused: Boolean = false,
    ): LearningTopic = LearningTopic(
        id = id,
        title = title,
        summary = summary,
        category = category,
        subtopics = listOf(
            LearningSubtopic(
                id = "$id-overview",
                title = "Overview runner",
                summary = "Phase 0 placeholder. Later phases replace this with concrete subtopic examples.",
                isUiFocused = isUiFocused,
                run = runner,
            ),
        ),
    )

    private fun topic(
        id: String,
        title: String,
        summary: String,
        category: String,
        subtopics: List<LearningSubtopic>,
    ): LearningTopic = LearningTopic(
        id = id,
        title = title,
        summary = summary,
        category = category,
        subtopics = subtopics,
    )
}

data class LearningTopic(
    val id: String,
    val title: String,
    val summary: String,
    val category: String,
    val subtopics: List<LearningSubtopic>,
)

data class LearningSubtopic(
    val id: String,
    val title: String,
    val summary: String,
    val isUiFocused: Boolean,
    val run: (LearningLogger) -> Unit,
)
