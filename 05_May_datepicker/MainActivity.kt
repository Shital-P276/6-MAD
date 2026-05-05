package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RegistrationForm(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationForm(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var name by remember { mutableStateOf("") }
    var showDatePicker by remember { mutableStateOf(false) }
    var showConfirmDialog by remember { mutableStateOf(false) }

    val datePickerState = rememberDatePickerState()
    
    // Formatting the selected date for display
    val formattedDate = datePickerState.selectedDateMillis?.let {
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        sdf.timeZone = TimeZone.getTimeZone("UTC")
        sdf.format(Date(it))
    } ?: ""

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "User Registration",
            style = MaterialTheme.typography.headlineMedium
        )

        // Name Field
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Full Name") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        // Birthdate Field (Read-only, opens DatePicker on icon click)
        OutlinedTextField(
            value = formattedDate,
            onValueChange = { },
            label = { Text("Birthdate") },
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { showDatePicker = true }) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Select Date"
                    )
                }
            }
        )

        // Submit Button
        Button(
            onClick = { showConfirmDialog = true },
            modifier = Modifier.fillMaxWidth(),
            enabled = name.isNotBlank() && formattedDate.isNotBlank()
        ) {
            Text("Submit")
        }
    }

    // Material 3 Date Picker Dialog
    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(onClick = { showDatePicker = false }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePicker = false }) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }

    // Confirmation Alert Dialog for submission
    if (showConfirmDialog) {
        AlertDialog(
            onDismissRequest = { showConfirmDialog = false },
            title = { Text("Confirm Submission") },
            text = {
                Text("Are you sure you want to submit the form?")
            },
            confirmButton = {
                Button(onClick = { 
                    showConfirmDialog = false 
                    Toast.makeText(context, "Form Submitted Successfully!", Toast.LENGTH_SHORT).show()
                }) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = { showConfirmDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationFormPreview() {
    MyApplicationTheme {
        RegistrationForm()
    }
}
