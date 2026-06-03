package com.example.labwork26

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.labwork26.data.User
import com.example.labwork26.ui.theme.LabWork26Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork26Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ListViewPreview(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

class UserViewModel : ViewModel(){
    var UserList: MutableList<User> = mutableListOf<User>(
        User("Cava", "qwerty", ""),
        User("Roman", "123", "")
    )

    fun AddUser(user: User){
        UserList.add(user)
    }
}

@Composable
fun ListViewPreview(vm: UserViewModel = viewModel(), modifier: Modifier = Modifier) {
    val login = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    LabWork26Theme {
        Column() {
            LazyColumn(modifier) {
                items(vm.UserList.toList()){
                    user -> Text("${user.login}")
                }
            }
            OutlinedTextField(
                value = login.value,
                onValueChange = { login.value = it },
                label = { Text("Логин") }
            )
            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text("Пароль") }
            )
            OutlinedTextField(
                value = email.value,
                onValueChange = { email.value = it },
                label = { Text("Email") }
            )
            Button({
                if (!login.value.isNullOrEmpty() && !password.value.isNullOrEmpty() && !email.value.isNullOrEmpty())
                    vm.AddUser(User(login.value, password.value, email.value))
                vm.AddUser(User(login.value, password.value, email.value))
            }) {
                Text("Добавить")
            }
        }
    }
}

@Composable
fun UserViewPreview(vm: UserViewModel = viewModel(), modifier: Modifier = Modifier) {
    val login = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    LabWork26Theme {
        Column() {
            LazyColumn(modifier) {
                items(vm.UserList.toList()){
                        user -> Text("${user.login}")
                }
            }
            OutlinedTextField(
                value = login.value,
                onValueChange = { login.value = it },
                label = { Text("Логин") }
            )
            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text("Пароль") }
            )
            OutlinedTextField(
                value = email.value,
                onValueChange = { email.value = it },
                label = { Text("Email") }
            )
            Button({
                if (!login.value.isNullOrEmpty() && !password.value.isNullOrEmpty() && !email.value.isNullOrEmpty())
                    vm.AddUser(User(login.value, password.value, email.value))
                vm.AddUser(User(login.value, password.value, email.value))
            }) {
                Text("Добавить")
            }
        }
    }
}

@Composable
fun GetUserView(vm: UserViewModel = viewModel(), modifier: Modifier = Modifier){
    Column() {
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