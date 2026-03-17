package com.example.xx1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.xx1.ui.theme.Xx1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Xx1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        color = Color.Cyan
                    ) {
                        // Calling the function for Question 1
                        DataTypesDemo("Shital Patil", "B77")
                    }
                }
            }
        }
    }
}

@Composable
fun DataTypesDemo(name: String, rollno
: String) {
    // --- Question 1: Demonstrating Kotlin Data Types ---
    val studentName: String = name          // String
    val studentrollno
    : String = rollno
    // String
    val rollNumber: Int = 77                // Integer
    val labScore: Double = 9.5              // Double (Decimal)
    val isPresent: Boolean = true           // Boolean (True/False)

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = studentName, fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Text(text = "rollno" +
                ": $studentrollno" +
                "", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(30.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Kotlin Data Types Demo", fontWeight = FontWeight.Bold, color = Color.Blue)
                Divider(modifier = Modifier.padding(vertical = 8.dp))

                Text(text = "Int (Roll No): $rollNumber")
                Text(text = "Double (Score): $labScore")
                Text(text = "Boolean (Present): $isPresent")
            }
        }
    }
}
