package com.example.labwork18

import android.inputmethodservice.Keyboard
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.labwork18.ui.theme.LabWork18Theme
import java.nio.file.WatchEvent
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork18Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ScreenButton(modifier = Modifier.padding(innerPadding))
                    //ScreenProducts(modifier = Modifier.padding(innerPadding))
                    //ScreenProduct(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenButton(modifier: Modifier = Modifier){
    val clickCount = remember { mutableStateOf(0) }
    Column() {
        Button(onClick = { clickCount.value++ },
            modifier = Modifier
                .padding(5.dp)) {
            Text("Текст") }
        OutlinedButton(onClick = { clickCount.value++ },
            modifier = Modifier
                .padding(5.dp)) {
            Text("Текст") }
        TextButton(onClick = { clickCount.value++ },
            modifier = Modifier
                .padding(5.dp)) {
            Text("Текст") }
        Button(onClick = { clickCount.value++ },
            modifier = Modifier
                .padding(5.dp)) {
            Text("Текст") }
        Button(onClick = { clickCount.value++ },
            modifier = Modifier
                .padding(5.dp)) {
            Text("Текст") }
        Button(onClick = { clickCount.value++ },
            modifier = Modifier
                .padding(5.dp)) {
            Text("Текст") }
        var buttonBackgroundColor by remember { mutableStateOf(Random.nextInt(255)) }
            Button(onClick = {
                buttonBackgroundColor = Random.nextInt(255)
                clickCount.value++
            }, modifier = Modifier.background(Color(buttonBackgroundColor, buttonBackgroundColor, buttonBackgroundColor))){
                Text("Текст") }
        Text(clickCount.value.toString())
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenProducts(modifier: Modifier = Modifier) {
    var listProduct = mutableListOf("Банан", "Яблоко", "Груша", "Авокадо", "Манго", "Ананас", "Киви", "Авокадо", "Авокадо", "Авокадо", "Авокадо", "Авокадо", "Авокадо", "Авокадо", "Авокадо", "Авокадо", "Авокадо", "Авокадо", "Авокадо", "Авокадо", "Авокадо", "Авокадо", "Авокадо", "Авокадо", "Авокадо")
    val clickCount = remember { mutableStateOf(0) }
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        listProduct.forEach {
            Row(modifier = Modifier) {
                Text(it)
                Button(onClick = { clickCount.value++ }) {
                    Icon(Icons.Default.Add, "Удалить")
                }
            }
        }
        Text("Количество товаров: $clickCount")
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenProduct(modifier: Modifier = Modifier) {
    var countProduct by remember { mutableStateOf(0) }
    var isEnabledAddButton by remember { mutableStateOf(true) }
    var isEnabledDeleteButton by remember { mutableStateOf(true) }
    Column() {
        Text("Название: Товар")
        Text("Цена: Условно 100")
        Text("Заказано штук: $countProduct")
        Text("Итоговая цена: ${countProduct*100}")
        Row() {
            IconButton(onClick = {
                if (countProduct == 10) {
                    isEnabledAddButton = !isEnabledAddButton
                    isEnabledAddButton = isEnabledDeleteButton
                }
                else{
                    countProduct++
                }},
                enabled = isEnabledAddButton) {
                Icon(Icons.Filled.Add, "")
            }
            IconButton(onClick = {
                if (countProduct <= 0) {
                    isEnabledDeleteButton = !isEnabledDeleteButton
                    isEnabledDeleteButton = isEnabledAddButton
                }
                else{
                    countProduct--
                }},
                enabled = isEnabledDeleteButton){
                Icon(Icons.Filled.Delete, "")
            }
        }
    }
}