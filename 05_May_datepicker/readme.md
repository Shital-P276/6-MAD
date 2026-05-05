# Date Picker and Alert Dialog Demo

To recreate this demo in a new Android Studio project (Empty Compose Activity template), you mainly need to update the `MainActivity.kt` file.

## Files to Replace

1. **MainActivity.kt**
   - **Path:** `app/src/main/java/com/example/myapplication/MainActivity.kt`
   - **Description:** Contains the logic for the Name field, the Birthdate DatePicker, and the submission confirmation AlertDialog.

## Prerequisites

Ensure your `libs.versions.toml` or `build.gradle` includes Material 3 dependencies, as this demo uses:
- `androidx.compose.material3:material3`
- `androidx.compose.material:material-icons-extended` (for `Icons.Default.DateRange`)

## Implementation Details
- **RegistrationForm**: The main composable function.
- **DatePickerState**: Manages the state of the Material 3 Date Picker.
- **AlertDialog**: Used for confirming the final submission.
- **Toast**: Provides visual feedback upon successful "submission".
