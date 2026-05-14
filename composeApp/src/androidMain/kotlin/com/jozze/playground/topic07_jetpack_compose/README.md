# Topic 07: Jetpack Compose

## Jetpack Compose Components Catalog

### 1. Standard Layouts
The foundational building blocks for positioning elements.
*   **`Column`**: Places items vertically.
*   **`Row`**: Places items horizontally.
*   **`Box`**: Stacks items on top of each other.
*   **`Spacer`**: Creates empty space between elements.

### 2. Display Components
Used to show information to the user.
*   **`Text`**: Displays formatted text (Material 3).
*   **`Image`**: Displays a painter or bitmap.
*   **`Icon`**: Displays a vector or bitmap icon (Material).
*   **`Canvas`**: Provides a surface for custom 2D drawing.

### 3. Interactive Components (Buttons & Actions)
Elements the user can click or tap.
*   **`Button`**: Standard Material filled button.
*   **`ElevatedButton`**, **`FilledTonalButton`**, **`OutlinedButton`**, **`TextButton`**.
*   **`IconButton`**: A clickable icon.
*   **`FloatingActionButton` (FAB)**: Prominent action button.

### 4. Text Input & Selection
Components for gathering user input.
*   **`TextField`**: Material filled input field.
*   **`OutlinedTextField`**: Input field with an outline.
*   **`Checkbox`**: For binary (on/off) or multiple selection.
*   **`Switch`**: For toggling a setting.
*   **`RadioButton`**: For selecting one option from a group.
*   **`Slider`**: For selecting a value from a range.

### 5. Collection Layouts (Lazy)
Efficiently render large lists or grids.
*   **`LazyColumn`**: Vertically scrolling list.
*   **`LazyRow`**: Horizontally scrolling list.
*   **`LazyVerticalGrid`**: Multi-column grid.
*   **`LazyHorizontalGrid`**: Multi-row grid.

### 6. Containers & Surfaces
Provide structure, background, and elevation.
*   **`Surface`**: Fundamental container providing color, shape, and elevation.
*   **`Card`**: Container with rounded corners and optional shadow.
*   **`Scaffold`**: Implements the basic Material Design visual layout structure (TopBar, BottomBar, FAB).
*   **`TopAppBar`** / **`BottomAppBar`**: Bars for actions and navigation.

### 7. Progress & Feedback
Communicate status to the user.
*   **`CircularProgressIndicator`**: A spinning loader.
*   **`LinearProgressIndicator`**: A progress bar.
*   **`AlertDialog`**: Interrupts the user with urgent information.
*   **`Snackbar`**: Brief message at the bottom of the screen.

### 8. Navigation & Menus
*   **`NavigationBar`** (formerly BottomNavigation): Main app navigation.
*   **`NavigationRail`**: Side navigation for tablets/large screens.
*   **`DropdownMenu`**: A popup list of options.
*   **`ModalBottomSheet`**: Content that slides up from the bottom.

---

## Modifiers

**Modifiers** are used to decorate or augment a composable. They allow you to change the composable's size, layout, appearance, or add high-level interactions.

### 1. Core Modifiers
*   **Layout:** `padding`, `size`, `fillMaxWidth`, `offset`.
*   **Appearance:** `background`, `border`, `clip`, `graphicsLayer`.
*   **Interaction:** `clickable`, `scrollable`, `pointerInput`.

### 2. Universal vs. Scope-Specific
*   **Universal:** Most modifiers (like `padding`) can be used on any composable.
*   **Scope-Specific:** Some only work inside specific parents. For example, `weight` only works inside a `Row` or `Column`, and `align` behaves differently inside a `Box` vs a `Column`.

### 3. Modifier Order
In Compose, **order matters**. Modifiers are applied from top to bottom (or left to right in a chain). Each modifier "wraps" the result of the previous one.

**Example: Padding vs. Background**
*   `Modifier.background(Color.Red).padding(16.dp)`: Background is applied first, then padding is added **inside**.
*   `Modifier.padding(16.dp).background(Color.Red)`: Padding is added first (transparent), then background is applied to the **inner area**.

**Example: Interaction**
*   `Modifier.clickable {}.padding(16.dp)`: Only the content (excluding padding) is clickable.
*   `Modifier.padding(16.dp).clickable {}`: The entire area (including padding) is clickable.

---

## Modifier Cheatsheet

### 1. Universal Modifiers (Everywhere)
These can be applied to any composable.

| Category | Modifiers |
| :--- | :--- |
| **Sizing** | `fillMaxSize()`, `fillMaxWidth()`, `fillMaxHeight()`, `width(dp)`, `height(dp)`, `size(dp)`, `wrapContentSize()` |
| **Padding** | `padding(all)`, `padding(horizontal, vertical)`, `padding(start, top, end, bottom)` |
| **Appearance** | `background(color, shape)`, `border(width, color, shape)`, `clip(shape)`, `alpha(0f-1f)` |
| **Graphics** | `graphicsLayer { scaleX, rotationZ, etc. }`, `shadow(elevation, shape)` |
| **Interaction** | `clickable { }`, `toggleable()`, `selectable()`, `combinedClickable()` |
| **Scrolling** | `verticalScroll(state)`, `horizontalScroll(state)` |
| **Input** | `pointerInput(key) { }`, `focusRequester(ref)`, `onFocusChanged { }` |
| **Semantics** | `semantics { }`, `testTag("id")`, `contentDescription = "..."` |

### 2. Scope-Specific Modifiers (Only inside Parents)

#### **BoxScope** (Inside `Box`)
*   **`align(Alignment)`**: Positions child within the Box (e.g., `Center`, `BottomEnd`).
*   **`matchParentSize()`**: Makes the child exactly the same size as the Box (after other children are measured).

#### **ColumnScope** (Inside `Column`)
*   **`weight(float)`**: Sizes child based on vertical space ratio.
*   **`align(Alignment.Horizontal)`**: Aligns child horizontally (e.g., `CenterHorizontally`).

#### **RowScope** (Inside `Row`)
*   **`weight(float)`**: Sizes child based on horizontal space ratio.
*   **`align(Alignment.Vertical)`**: Aligns child vertically (e.g., `CenterVertically`).
*   **`alignByBaseline()`**: Aligns text baselines of children.

#### **LazyItemScope** (Inside `LazyColumn` / `LazyRow` items)
*   **`fillParentMaxSize()`**: Fill the entire viewport of the list.
*   **`fillParentMaxWidth()`** / **`fillParentMaxHeight()`**: Fill width/height of the viewport.
*   **`animateItem()`**: Animates item moves/changes.

---

## `remember` and `rememberSaveable`

In Jetpack Compose, both `remember` and `rememberSaveable` are used to store state, but they differ in how long that state persists.

### 1. `remember`
`remember` stores an object in the Composition. It is used to ensure that a value is not recalculated every time a Composable recomposes.

*   **Persistence:** Survives **recomposition**.
*   **Loss:** Cleared if the Composable is removed from the UI tree or if the Activity/Process is recreated (e.g., on screen rotation).
*   **Use Cases:**
    *   Expensive computations that shouldn't run on every frame.
    *   Ephemeral UI state that doesn't need to survive a rotation (e.g., an animation value or a "hovered" state).
    *   State that is already being managed/restored by a `ViewModel`.

### 2. `rememberSaveable`
`rememberSaveable` behaves like `remember`, but it also hooks into the Android `Bundle` mechanism (saved instance state).

*   **Persistence:** Survives **recomposition**, **configuration changes** (rotation, dark mode toggle), and **system-initiated process death**.
*   **Loss:** Cleared when the user explicitly closes the app or finishes the Activity.
*   **Constraints:** Can only store data types that can be put in a `Bundle` (Primitives, `Parcelable`, `Serializable`). For custom objects, you must provide a `Saver`.
*   **Use Cases:**
    *   User input in a `TextField` (so it's not lost when they rotate the phone).
    *   Scroll position in a list.
    *   Selection state in a menu.

### Comparison Summary

| Feature | `remember` | `rememberSaveable` |
| :--- | :--- | :--- |
| **Survives Recomposition** | Yes | Yes |
| **Survives Rotation** | No | Yes |
| **Survives Process Death** | No | Yes |
| **Storage Mechanism** | Memory (Composition) | `Bundle` (SavedState) |
| **Data Types** | Anything | Primitive/Parcelable (or with `Saver`) |

---
