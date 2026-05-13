package com.jozze.playground.topic07_jetpack_compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Screen-first demos for Topic 07: Jetpack Compose.
 *
 * These examples intentionally live in the app module because they depend on
 * Compose UI APIs. The shared catalog owns topic metadata; this file owns the
 * visible learning output.
 */
@Composable
fun ComposeTopicDemo(subtopicId: String, modifier: Modifier = Modifier) {
    DemoShell(modifier = modifier) {
        when (subtopicId) {
            "topic07-mental-model" -> MentalModelDemo()
            "topic07-state" -> StateManagementDemo()
            "topic07-layouts" -> LayoutsDemo()
            "topic07-lists" -> ListsDemo()
            "topic07-modifiers" -> ModifiersDemo()
            "topic07-side-effects" -> SideEffectsDemo()
            "topic07-composition-local" -> CompositionLocalDemo()
            "topic07-theming" -> ThemingDemo()
            else -> Text("Select a Compose subtopic to render its UI demo.")
        }
    }
}

@Composable
private fun DemoShell(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            content()
        }
    }
}

@Composable
private fun MentalModelDemo() {
    var count by remember { mutableIntStateOf(0) }
    val label = if (count == 0) "No clicks yet" else "Clicked $count times"

    DemoTitle("Declarative UI + UDF")
    Text("State is the input. UI is recalculated from that state.")
    Text(label, fontWeight = FontWeight.SemiBold)
    Button(onClick = { count++ }) {
        Text("Send Action")
    }

    /*
    Wrong:
    val textView = findViewById<TextView>(...)
    textView.text = "Clicked"

    Why wrong in Compose:
    Compose UI should be described from state. Mutate the state, not a retained
    view instance.
    */
}

@Composable
private fun StateManagementDemo() {
    var volatileCount by remember { mutableIntStateOf(0) }
    var savedCount by rememberSaveable { mutableIntStateOf(0) }
    var enabled by remember { mutableStateOf(true) }

    DemoTitle("remember + rememberSaveable")
    Text("remember survives recomposition. rememberSaveable also survives common recreation paths.")
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Button(enabled = enabled, onClick = { volatileCount++ }) {
            Text("remember: $volatileCount")
        }
        Button(enabled = enabled, onClick = { savedCount++ }) {
            Text("saveable: $savedCount")
        }
    }
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("Buttons enabled")
        Switch(checked = enabled, onCheckedChange = { enabled = it })
    }

    /*
    Wrong:
    var count = 0
    Button(onClick = { count++ }) { Text("$count") }

    Why wrong:
    A local variable is recreated during recomposition and does not notify
    Compose when it changes. Use Compose state such as mutableStateOf.
    */
}

@Composable
private fun LayoutsDemo() {
    DemoTitle("Column + Row + Box")
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            DemoChip("Row item 1")
            DemoChip("Row item 2")
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp)
                .background(MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center,
        ) {
            Text("Box overlays and aligns children")
        }
    }

    /*
    Wrong:
    Nesting many Columns and Rows for a complex responsive screen.

    Why wrong:
    Basic layouts are good, but complex constraints may need ConstraintLayout or
    a custom layout to keep hierarchy and measurement cost under control.
    */
}

@Composable
private fun ListsDemo() {
    val lessons = remember {
        listOf(
            LessonItem("state", "State drives UI"),
            LessonItem("layout", "Layouts measure children"),
            LessonItem("effects", "Effects run outside rendering"),
        )
    }

    DemoTitle("LazyColumn + stable keys")
    LazyColumn(
        modifier = Modifier.height(150.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        items(items = lessons, key = { it.id }) { lesson ->
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.surface,
            ) {
                Column(Modifier.padding(10.dp)) {
                    Text(lesson.id, fontWeight = FontWeight.SemiBold)
                    Text(lesson.summary)
                }
            }
        }
    }

    /*
    Wrong:
    items(lessons) { lesson -> ... } // for reorderable/stateful rows

    Why risky:
    Without stable keys, item state can move to the wrong row when list order or
    identity changes.
    */
}

@Composable
private fun ModifiersDemo() {
    var selected by remember { mutableStateOf(false) }
    val borderColor = if (selected) MaterialTheme.colorScheme.primary else Color.Gray

    DemoTitle("Modifier order matters")
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        Box(
            modifier = Modifier
                .size(96.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.tertiaryContainer)
                .border(2.dp, borderColor, RoundedCornerShape(8.dp))
                .clickable { selected = !selected },
            contentAlignment = Alignment.Center,
        ) {
            Text("clip first")
        }
        Box(
            modifier = Modifier
                .size(96.dp)
                .graphicsLayer(rotationZ = if (selected) 4f else 0f)
                .border(2.dp, borderColor, RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.surface),
            contentAlignment = Alignment.Center,
        ) {
            Text("graphics")
        }
    }

    /*
    Wrong:
    Modifier.clickable(...).padding(24.dp)

    Why potentially wrong:
    The clickable area is applied before padding, so only the unpadded content may
    be clickable. Put padding before clickable when the full padded area should respond.
    */
}

@Composable
private fun SideEffectsDemo() {
    var count by remember { mutableIntStateOf(0) }
    var message by remember { mutableStateOf("No coroutine launched") }
    val scope = rememberCoroutineScope()
    val isEven by remember { derivedStateOf { count % 2 == 0 } }
    val produced by produceState(initialValue = "produceState loading", count) {
        delay(50)
        value = "produceState saw count=$count"
    }

    LaunchedEffect(count) {
        message = "LaunchedEffect reacted to count=$count"
    }
    DisposableEffect(Unit) {
        onDispose {
            // Cleanup hook for subscriptions, listeners, or observers.
        }
    }
    SideEffect {
        // Runs after every successful composition. Keep it quick and non-blocking.
    }

    DemoTitle("Effect handlers")
    Text(message)
    Text(produced)
    Text("derivedStateOf says count is ${if (isEven) "even" else "odd"}")
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Button(onClick = { count++ }) {
            Text("Count $count")
        }
        OutlinedButton(
            onClick = {
                scope.launch {
                    delay(50)
                    message = "rememberCoroutineScope launched from callback"
                }
            },
        ) {
            Text("Launch")
        }
    }

    /*
    Wrong:
    delay(1000) directly in a composable body

    Why wrong:
    Composable bodies describe UI and may run often. Suspend work belongs in an
    effect such as LaunchedEffect or in a ViewModel.
    */
}

@Composable
private fun CompositionLocalDemo() {
    DemoTitle("CompositionLocal")
    Text("A parent provides a value that descendants can read without explicit parameters.")
    CompositionLocalProvider(LocalLearningTone provides "Advanced") {
        ToneReader()
    }

    /*
    Wrong:
    Using CompositionLocal for every dependency.

    Why wrong:
    It hides required inputs. Prefer explicit parameters for normal data and use
    CompositionLocal for cross-cutting values such as theme, density, or context.
    */
}

@Composable
private fun ToneReader() {
    DemoChip("LocalLearningTone=${LocalLearningTone.current}")
}

@Composable
private fun ThemingDemo() {
    DemoTitle("MaterialTheme")
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.primaryContainer,
    ) {
        Column(Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text("Title uses typography.titleMedium", style = MaterialTheme.typography.titleMedium)
            Text("Body uses color and shape from the active theme.", style = MaterialTheme.typography.bodyMedium)
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .background(MaterialTheme.colorScheme.primary, MaterialTheme.shapes.small),
            )
        }
    }

    /*
    Wrong:
    Text("Title", fontSize = 31.sp, color = Color(0xFF123456))

    Why risky:
    Hardcoded typography and colors drift from the design system and usually
    ignore dark mode, accessibility, and consistency.
    */
}

@Composable
private fun DemoTitle(title: String) {
    Text(title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
}

@Composable
private fun DemoChip(text: String) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.surface,
    ) {
        Text(text = text, modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp))
    }
}

private val LocalLearningTone = staticCompositionLocalOf { "Beginner" }

private data class LessonItem(
    val id: String,
    val summary: String,
)
