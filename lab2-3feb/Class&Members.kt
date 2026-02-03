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
import androidx.compose.ui.unit.dp
import com.example.lab2_3feb.ui.theme.Lab2_3febTheme
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter // Optional, but good to have

// 1. Define the Student class
class Student(val name: String, val dept: String) {
    // Member function to return the formatted information
    fun displayInfo(): String {
        return "Student Name: $name\nDepartment: $dept"
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab2_3febTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // 2. Instantiate and use the class
                    val myStudent = Student("Shital Patil", "Computer Engineering")

                    DisplayStudentInfo(
                        student = myStudent,
                        modifier = Modifier.padding(innerPadding).padding(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun DisplayStudentInfo(student: Student, modifier: Modifier = Modifier) {
    // 3. Call the member function to get the text
    Text(
        text = "Class & Members - 3 Feb\n\n${student.displayInfo()}",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun StudentPreview() {
    Lab2_3febTheme {
        // Create a mock student for the preview surface
        val mockStudent = Student("Shital Patil", "CSE Dept")

        DisplayStudentInfo(
            student = mockStudent,
            modifier = Modifier.padding(16.dp)
        )
    }
}
