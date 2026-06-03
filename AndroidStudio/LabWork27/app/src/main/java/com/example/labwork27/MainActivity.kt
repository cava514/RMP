package com.example.labwork27

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.labwork27.data.User
import com.example.labwork27.data.UserService
import com.example.labwork27.ui.theme.LabWork27Theme
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork27Theme {
                val service: UserService = UserService()
                val navController = rememberNavController()
                Scaffold (modifier = Modifier) { innerpadding ->
                    NavBar(
                        navController,
                        modifier = Modifier.padding(innerpadding)
                    )
                    NavHost(navController, "registration") {
                        composable("registration") {
                            Registration(service, navController = navController, modifier = Modifier.padding(innerpadding))
                        }
                        composable("authorization") {
                            Authorization(service, navController = navController, modifier = Modifier.padding(innerpadding))
                        }
                        composable("profile") {
                            Profile(navController = navController, "", modifier = Modifier.padding(innerpadding))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Registration(service: UserService, navController: NavController, modifier: Modifier = Modifier){
    val login = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Логин:")
        OutlinedTextField(
            value = login.value,
            onValueChange = { login.value = it },
            label = {
                Row() {
                    Icon(Icons.Filled.Person, contentDescription = "Пользователь")
                    Text("Логин") }
            }
        )
        Text("Пароль:")
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = {
                Text("Пароль")
            }
        )
        Button(
            {
                if (!login.value.isNullOrEmpty() && !password.value.isNullOrEmpty()){
                    val maxId = service.userList.maxBy { it.id }
                    service.addUser(User(maxId.id + 1, login.value, password.value))
                    navController.navigate("profile")
                }
            },
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(Color(red = 65, green = 170, blue = 255)),
            shape = RectangleShape
        ) {
            Text("Зарегестрироваться")
        }
        Text("Уже есть аккаунт?")
        Button(
            {
                navController.navigate("authorization")
            },
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,
                contentColor = Color.Black
            ),
            shape = RectangleShape
        ) {
            Text("Перейти к авторизации")
        }
    }
}

@Composable
fun Authorization(service: UserService, navController: NavController, modifier: Modifier = Modifier){
    var login = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Логин:")
        OutlinedTextField(
            value = login.value,
            onValueChange = { login.value = it },
            label = {
                Row() {
                    Icon(Icons.Filled.Person, contentDescription = "Пользователь")
                    Text("Логин")
                }
            }
        )
        Text("Пароль:")
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = {
                Text("Пароль")
            }
        )
        Button(
            {
                if (!login.value.isNullOrEmpty() && !password.value.isNullOrEmpty()){
                    val checkLogin = service.userList.filterNot { it.login == login.value && it.password == password.value }
                    if (!checkLogin.isNullOrEmpty())
                        navController.navigate("profile")
                }
            },
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(Color(red = 65, green = 170, blue = 255)),
            shape = RectangleShape
        ) {
            Text("Войти")
        }
        Text("Нет аккаунта?")
        Button(
            {
                navController.navigate("registration")
            },
            modifier = Modifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,
                contentColor = Color.Black
            ),
            shape = RectangleShape
        ) {
            Text("Перейти к регистрации")
        }
    }
}

@Composable
fun Profile(navController: NavController, login: String?, modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(

        ) {
            Icon(Icons.Filled.AccountCircle, contentDescription = "Аккаунт")
            Text("$login")
        }
        Text("О себе:")
        OutlinedTextField(
            value = "",
            onValueChange = {}
        )
        Button(
            {},
            modifier = Modifier
                .background(Color.White),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,
                contentColor = Color.Black
            ),
            shape = RectangleShape
        ) {
            Text("Выйти")
        }
    }
}

enum class Screens(val route: String){
    REGISTRATION("registration"),
    AUTHORIZATION("authorization"),
    PROFILE("profile")
}

@Composable
fun NavBar(navController: NavController, modifier: Modifier = Modifier){
    Row(Modifier
        .fillMaxWidth()
        .padding(5.dp)) {
        Text("Registration",
            Modifier
                .weight(1f)
                .clickable {
                    navController.navigate(
                        Screens.REGISTRATION.route
                    )
                },
            fontSize = 25.sp
        )
        Text("Authorization",
            Modifier
                .weight(1f)
                .clickable {
                    navController.navigate(
                        Screens.AUTHORIZATION.route
                    )
                },
            fontSize = 25.sp
        )
        Text("Profile",
            Modifier
                .weight(1f)
                .clickable {
                    navController.navigate(
                        Screens.PROFILE.route
                    )
                },
            fontSize = 25.sp
        )
    }
}