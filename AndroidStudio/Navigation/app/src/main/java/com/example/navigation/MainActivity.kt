package com.example.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigation.pseudo.Menu
import com.example.navigation.pseudo.PseudoNavApp
import com.example.navigation.pseudo.Screen1
import com.example.navigation.pseudo.Screen2
import com.example.navigation.pseudo.currentScreen
import com.example.navigation.ui.theme.NavigationTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Column {
                NavBar(navController)
                NavHost(navController, "home") {
                    composable("home") {
                        Home()
                    }

                    composable(Screens.PROFILE.route + "/{userId}",
                        arguments = listOf(
                            navArgument("userId") {
                            type = NavType.IntType
                        }
                        )) { stackEntry ->

                        val userId = stackEntry.arguments?.getInt("userId")

                        Profile(userId)
                    }

                    composable(Screens1.About.route) {
                        About()
                    }
                }
            }
        }
    }
}
enum class Screens(val route: String){
    HOME("home"),
    PROFILE("profile"),
    ABOUT("about")
}

sealed class Screens1(val route: String){
    object Home: Screens1("home")
    object Profile: Screens1("profile/{userId}"){
        fun createRoute(userId: Int) = "profile/${userId}"
    }
    object About: Screens1("about")
}

@Composable
fun NavBar(navController: NavController){
    Row(Modifier
        .fillMaxWidth()
        .padding(5.dp)) {
        Text("Home",
            Modifier
                .weight(1f)
                .clickable {
                    navController.navigate(Screens.HOME.route)
                },
            fontSize = 25.sp
        )
        Text("Profile",
            Modifier
                .weight(1f)
                .clickable {
                    navController.navigate(
                        Screens1.Profile.createRoute(Random.nextInt(100))
                    )
                },
            fontSize = 25.sp
        )
        Text("About",
            Modifier
                .weight(1f)
                .clickable {
                    navController.navigate(Screens.ABOUT.route)
                },
            fontSize = 25.sp
        )
    }
}

@Composable
fun Home(){
    Text("Главная", fontSize = 30.sp)
}

@Composable
fun Profile(id: Int?){
    Text("Профиль $id", fontSize = 30.sp)
}

@Composable
fun About(){
    Text("О программе", fontSize = 30.sp)
}