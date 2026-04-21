To replicate your project on another PC without uploading everything, you only need to update these three files and include your image file.
1. The Main UI Logic
File: app/src/main/java/com/example/assi_01/MainActivity.kt Copy and paste the entire content of this file. It contains the navigation logic, the Home screen with the watch, and the new "More" list view.
2. Dependency Definitions
File: gradle/libs.versions.toml Add this line under the [libraries] section:
TOML
toml
[libraries]
# ... other libraries ...
androidx-compose-material-icons-extended = { group = "androidx.compose.material", name = "material-icons-extended" }
3. Build Configuration
File: app/build.gradle.kts Add the implementation line inside the dependencies { ... } block:
Kotlin
dependencies {
    // ... other dependencies ...
    implementation(libs.androidx.compose.material.icons.extended)
}
4. Image Asset
File Path: app/src/main/res/drawable/watch_image.jpg Ensure you manually copy your watch_image.jpg into this folder on the new PC.
Summary of what to do on the new PC:
1.
Create a new "Empty Compose Activity" project named Assi_01.
2.
Paste the code into MainActivity.kt.
3.
Add the material-icons-extended line to libs.versions.toml.
4.
Add the implementation line to app/build.gradle.kts.
5.
Drop your watch_image.jpg into the res/drawable folder.
6.
Click "Sync Now" in Android Studio
