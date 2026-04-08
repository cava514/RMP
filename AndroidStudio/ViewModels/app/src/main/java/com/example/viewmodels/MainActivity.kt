package com.example.viewmodels

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viewmodels.ui.theme.ViewModelsTheme
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ViewModelsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)){
                        CounterView()
                    }
                }
            }
        }
    }
}

class CounterViewModel: ViewModel(){
    var count by mutableStateOf(0)

    fun increase(){
        count++
    }
}

class LoginViewModel: ViewModel(){
    var login by mutableStateOf("")
    var password by mutableStateOf("")

    fun authorize(): Boolean{
        return login == "admin" && password == "admin"
    }
}

@Composable
fun LoginView(vm: LoginViewModel = viewModel()){
    Column {
        OutlinedTextField(vm.login, {vm.login = it})
        OutlinedTextField(vm.password, {vm.password = it})
        var success by remember { mutableStateOf(false) }

        if (success){
            AlertDialog({success = false},
                {Button({ success = false }){
                Text("Ок")
            }})
        }

        Button({success = vm.authorize()}) {
            Text("Войти")
        }
    }
}

@Composable
fun CounterView(vm: CounterViewModel = viewModel()){
    Button({vm.increase()}){
        Text(vm.count.toString())
    }
}

@Composable
fun CounterViewWithoutVM(){
    var count by remember { mutableStateOf(0) }
    Button({count++}){
        Text(count.toString())
    }
}