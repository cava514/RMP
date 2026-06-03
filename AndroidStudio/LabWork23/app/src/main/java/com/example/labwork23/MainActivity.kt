package com.example.labwork23

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.labwork23.ui.theme.LabWork23Theme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val checkedState = remember { mutableStateOf(false) }
            LabWork23Theme(darkTheme = checkedState.value) {
                val navController = rememberNavController()
                Scaffold (modifier = Modifier) { innerpadding ->
                    NavBar(navController, modifier = Modifier.padding(innerpadding))
                    NavHost(navController, "home") {
                        composable("home") {
                            Home(modifier = Modifier.padding(innerpadding))
                        }
                        composable("about") {
                            About(modifier = Modifier.padding(innerpadding))
                        }
                        composable("setting") {
                            Setting(checkedState.value, modifier = Modifier.padding(innerpadding))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Home(modifier: Modifier = Modifier){
    Column(modifier = modifier) {
        Text("Главная", fontSize = 30.sp)
    }
}

@Composable
fun About(modifier: Modifier = Modifier){
    Column(modifier = modifier) {
        Text("О программе", fontSize = 30.sp)
    }
}

@Composable
fun Setting(checkedState: Boolean, modifier: Modifier = Modifier) {
    val checkedState1 = remember { mutableStateOf(false) }
    val checkedState2 = remember { mutableStateOf(false) }
    Column(modifier = modifier) {
        Row() {
            Switch(
                checked = checkedState1.value,
                onCheckedChange = {
                    checkedState1.value = it
                }
            )
            Text("Светлая/Темная", Modifier)
        }
        Row() {
            Switch(
                checked = checkedState2.value,
                onCheckedChange = { checkedState2.value = it }
            )
            Text("Светлый контраст/Темный контраст", Modifier)
        }
    }
}

enum class Screens(val route: String){
    HOME("home"),
    ABOUT("about"),
    SETTING("setting")
}

@Composable
fun NavBar(navController: NavController, modifier: Modifier = Modifier){
    Row(Modifier
        .fillMaxWidth()
        .padding(5.dp)) {
        Text("Home",
            Modifier
                .weight(1f)
                .clickable {
                    navController.navigate(
                        Screens.HOME.route
                    )
                },
            fontSize = 25.sp
        )
        Text("About",
            Modifier
                .weight(1f)
                .clickable {
                    navController.navigate(
                        Screens.ABOUT.route
                    )
                },
            fontSize = 25.sp
        )
        Text("Setting",
            Modifier
                .weight(1f)
                .clickable {
                    navController.navigate(
                        Screens.SETTING.route
                    )
                },
            fontSize = 25.sp
        )
    }
}