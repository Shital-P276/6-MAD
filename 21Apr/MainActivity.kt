package com.example.assi_01

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assi_01.ui.theme.Assi_01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assi_01Theme {
                MainScreen()
            }
        }
    }
}

enum class Screen {
    Home, Gallery, More
}

@Composable
fun MainScreen() {
    var selectedScreen by remember { mutableStateOf(Screen.Home) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { 
            BottomNavigationBar(
                selectedScreen = selectedScreen,
                onScreenSelected = { selectedScreen = it }
            ) 
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedScreen) {
                Screen.Home -> HomeContent()
                Screen.Gallery -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { Text("Gallery Screen") }
                Screen.More -> MoreScreen()
            }
        }
    }
}

@Composable
fun HomeContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        TopHeader()
        Spacer(modifier = Modifier.weight(1f))
        WatchDisplay()
        Spacer(modifier = Modifier.weight(1f))
        ActionsGrid()
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun MoreScreen() {
    val items = listOf(
        "Settings" to Icons.Default.Settings,
        "Account" to Icons.Default.AccountCircle,
        "Notifications" to Icons.Default.Notifications,
        "Privacy" to Icons.Default.Lock,
        "Help & Support" to Icons.Default.Info,
        "About" to Icons.Default.Info,
        "Logout" to Icons.Default.ExitToApp
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "More Options",
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(items) { (title, icon) ->
                ListItem(
                    headlineContent = { Text(title) },
                    leadingContent = {
                        Icon(icon, contentDescription = null)
                    },
                    modifier = Modifier.clickable { /* Handle click */ }
                )
                HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp), thickness = 0.5.dp, color = Color.LightGray)
            }
        }
    }
}

@Composable
fun TopHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Profile",
            modifier = Modifier.size(32.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = "Hello,", fontSize = 14.sp, color = Color.Gray)
            Text(text = "Shital", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun WatchDisplay() {
    Image(
        painter = painterResource(id = R.drawable.watch_image),
        contentDescription = "Smart Watch",
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp),
        contentScale = ContentScale.FillHeight
    )
}

data class ActionItem(val name: String, val icon: ImageVector, val color: Color)

@Composable
fun ActionsGrid() {
    val context = LocalContext.current
    val items = listOf(
        ActionItem("Battery", Icons.Default.BatteryFull, Color(0xFF64B5F6)),
        ActionItem("Camera", Icons.Default.CameraAlt, Color(0xFF4FC3F7)),
        ActionItem("Media", Icons.Default.PlayCircleOutline, Color(0xFF81C784)),
        ActionItem("Bluetooth", Icons.Default.Bluetooth, Color(0xFF90A4AE)),
        ActionItem("WiFi", Icons.Default.Wifi, Color(0xFFBA68C8)),
        ActionItem("Call", Icons.Default.Call, Color(0xFFE57373))
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items) { item ->
            ActionCard(item) {
                Toast.makeText(context, "${item.name} clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun ActionCard(item: ActionItem, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(item.color.copy(alpha = 0.2f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = item.name,
                tint = item.color,
                modifier = Modifier.size(28.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = item.name, fontSize = 12.sp, color = Color.DarkGray)
    }
}

@Composable
fun BottomNavigationBar(selectedScreen: Screen, onScreenSelected: (Screen) -> Unit) {
    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 8.dp
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = selectedScreen == Screen.Home,
            onClick = { onScreenSelected(Screen.Home) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Image, contentDescription = "Gallery") },
            label = { Text("Gallery") },
            selected = selectedScreen == Screen.Gallery,
            onClick = { onScreenSelected(Screen.Gallery) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.MoreHoriz, contentDescription = "More") },
            label = { Text("More") },
            selected = selectedScreen == Screen.More,
            onClick = { onScreenSelected(Screen.More) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Assi_01Theme {
        MainScreen()
    }
}
