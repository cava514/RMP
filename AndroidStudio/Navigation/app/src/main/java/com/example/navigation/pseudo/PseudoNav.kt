package com.example.navigation.pseudo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.navigation.R
import com.example.navigation.ui.theme.NavigationTheme

var currentScreen by mutableStateOf("Screen1")

@Composable
fun PseudoNavApp() {
    NavigationTheme() {
        Column(Modifier.fillMaxSize()) {
            Menu()
            when(currentScreen){
                "Screen1" -> Screen1()
                "Screen2" -> Screen2()
            }
        }
    }
}

@Composable
fun Menu(modifier: Modifier = Modifier){
    Row(modifier){
        Button({currentScreen = "Screen1"}) {
            Text("Экран1")
        }
        Button({currentScreen = "Screen2"}) {
            Text("Экран2")
        }
    }
}

@Composable
fun Screen1(){
    Box(Modifier.fillMaxSize().background(Color.Cyan)){
        Image(bitmap =
            ImageBitmap.imageResource(R.drawable.image),
            contentDescription = "Коть",
            modifier = Modifier.fillMaxSize())
    }

}

@Composable
fun Screen2(){
    Box(Modifier.fillMaxSize().background(Color.Magenta))
}