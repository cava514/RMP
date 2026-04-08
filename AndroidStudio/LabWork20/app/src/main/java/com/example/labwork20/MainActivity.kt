package com.example.labwork20

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.labwork20.ui.theme.LabWork20Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            LabWork20Theme {
                Scaffold(modifier = Modifier.fillMaxSize()
                    .statusBarsPadding()) { innerPadding ->
                    Column() {
                        NavBar(navController)
                        NavHost(navController,
                            "authorization",
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            composable("authorization") {
                                com.example.labwork20.Authorization({navController.navigate(Screens.LISTPRODUCT.route)}, {navController.navigate(Screens.REGISTRATION.route)})
                            }
                            composable("registration") {
                                com.example.labwork20.Registration({navController.navigate(Screens.LISTPRODUCT.route)})
                            }
                            composable("listProduct") {
                                com.example.labwork20.ListProduct({navController.navigate(Screens.PRODUCT.route)})
                            }
                            composable("product") {
                                com.example.labwork20.Product()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun NavBar(navController: NavController, modifier: Modifier = Modifier){
    Column(Modifier
        .fillMaxWidth()) {
        Text("Авторизация",
            Modifier
                .clickable {
                    navController.navigate(Screens.AUTHORIZATION.route)
                },
            fontSize = 25.sp
        )
        Text("Регистрация",
            Modifier
                .clickable {
                    navController.navigate(Screens.REGISTRATION.route)
                },
            fontSize = 25.sp
        )
        Text("Список продуктов",
            Modifier
                .clickable {
                    navController.navigate(Screens.LISTPRODUCT.route)
                },
            fontSize = 25.sp
        )
        Text("Продукт",
            Modifier
                .clickable {
                    navController.navigate(Screens.PRODUCT.route)
                },
            fontSize = 25.sp
        )
    }
}