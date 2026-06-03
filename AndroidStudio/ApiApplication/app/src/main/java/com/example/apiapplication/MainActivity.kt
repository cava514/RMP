package com.example.apiapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apiapplication.data.Product
import com.example.apiapplication.data.ProductApiService
import com.example.apiapplication.ui.theme.ApiApplicationTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApiApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier, vm: ProductViewModel = viewModel()) {
    Column(
        modifier = modifier
    ){
        val list by vm.products.collectAsState()
        var id by remember { mutableStateOf(0) }
        var name by remember { mutableStateOf("") }
        var price by remember { mutableStateOf(0.0) }

        OutlinedTextField(id.toString(), {id = it.toInt()})
        OutlinedTextField(name, {name = it})
        OutlinedTextField(price.toString(), {price = it.toDouble()})
        Button({vm.addProduct(id, name, price)}) {
            Text("Добавить")
        }
        LazyColumn() {
            items(list){ p->
                Text("${p.id} | ${p.name} | ${p.price}")
                IconButton({vm.deleteProduct(p.id)}){
                    Icon(Icons.Default.Delete, "Delete")
                }
            }
        }
    }
}