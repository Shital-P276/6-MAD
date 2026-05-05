# Date Picker and Alert Dialog Demo

To recreate this demo in a new Android Studio project (Empty Compose Activity template), you need to update/verify the following files.

## Files to Replace/Update

1. **MainActivity.kt**
   - **Path:** `app/src/main/java/com/example/myapplication/MainActivity.kt`
   - **Description:** Contains the logic for the Name field, the Birthdate DatePicker, and the submission confirmation AlertDialog.

2. **libs.versions.toml**
   - **Path:** `gradle/libs.versions.toml`
   - **Addition:** Added `androidx-compose-material-icons-extended` to the `[libraries]` section to support the `DateRange` icon.

3. **build.gradle.kts (Module :app)**
   - **Path:** `app/build.gradle.kts`
   - **Addition:** Added `implementation(libs.androidx.compose.material.icons.extended)` to the `dependencies` block.

## Implementation Details
- **RegistrationForm**: The main composable function.
- **DatePickerState**: Manages the state of the Material 3 Date Picker.
- **AlertDialog**: Used for confirming the final submission.
- **Toast**: Provides visual feedback upon successful "submission".

## Note on Package Name
If your new project has a different package name (e.g., `com.user.testapp`), remember to:
- Update the `package` declaration at the top of `MainActivity.kt`.
- Update the import for `MyApplicationTheme` to match your theme's location.
