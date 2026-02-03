package com.example.lab2_3feb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab2_3feb.ui.theme.Lab2_3febTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab2_3febTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // 1. Define a nullable variable
    val nullableSubtitle: String? = "hello"
    // 2. Safe call (?.) and Elvis operator (?:) in action
    // It tries to get length, but if null, defaults to 0
    val nameLength = nullableSubtitle?.length ?: 0

    Text(
        text = "Hello $name!\nNullable status: $nullableSubtitle\nDefault length: $nameLength",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab2_3febTheme {
        Greeting("Android") // No errors now because parameters haven't changed
    }
}

