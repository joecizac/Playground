package com.jozze.playground

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jozze.playground.core.catalog.LearningCatalog
import com.jozze.playground.core.catalog.LearningSubtopic
import com.jozze.playground.core.catalog.LearningTopic
import com.jozze.playground.core.logging.AndroidLearningLogger
import com.jozze.playground.topic07_jetpack_compose.ComposeTopicDemo

@Composable
@Preview
fun App() {
    MaterialTheme {
        val logger = remember { AndroidLearningLogger() }
        var selectedSubtopic by remember { mutableStateOf<LearningSubtopic?>(null) }
        var latestRunMessage by remember { mutableStateOf("Select a non-UI demo and run it to see output in Logcat.") }

        Scaffold { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                Text(
                    text = "KMP CMP Learning Playground",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = latestRunMessage,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(bottom = 24.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    items(LearningCatalog.topics, key = { it.id }) { topic ->
                        TopicCard(
                            topic = topic,
                            selectedSubtopic = selectedSubtopic,
                            onRunSubtopic = { subtopic ->
                                selectedSubtopic = subtopic
                                subtopic.run(logger)
                                latestRunMessage = if (subtopic.isUiFocused) {
                                    "${topic.title}: UI demo rendered on screen."
                                } else {
                                    "${topic.title}: output written to Logcat with tag Playground.${topic.id.replaceFirstChar { it.uppercase() }}."
                                }
                            },
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun TopicCard(
    topic: LearningTopic,
    selectedSubtopic: LearningSubtopic?,
    onRunSubtopic: (LearningSubtopic) -> Unit,
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainer),
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = topic.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.weight(1f),
                )
                Text(
                    text = topic.category,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary,
                )
            }
            Text(
                text = topic.summary,
                style = MaterialTheme.typography.bodyMedium,
            )
            topic.subtopics.forEach { subtopic ->
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text(
                        text = subtopic.title,
                        style = MaterialTheme.typography.labelLarge,
                    )
                    Text(
                        text = if (subtopic.isUiFocused) {
                            "UI output: ${subtopic.summary}"
                        } else {
                            "Logcat output: ${subtopic.summary}"
                        },
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                    Button(onClick = { onRunSubtopic(subtopic) }) {
                        Text(if (subtopic.isUiFocused) "Open UI Demo" else "Run Logcat Demo")
                    }
                    if (selectedSubtopic?.id == subtopic.id && subtopic.isUiFocused) {
                        ComposeTopicDemo(subtopicId = subtopic.id)
                    }
                }
            }
        }
    }
}
