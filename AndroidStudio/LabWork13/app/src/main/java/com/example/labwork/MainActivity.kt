package com.example.labwork

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.semantics.SemanticsProperties.Shape
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowInsetsAnimationCompat
import com.example.labwork.ui.theme.LabWorkTheme
import com.example.labwork.ui.theme.Pink40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWorkTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        group = "ИСПП-34,45",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(group: String, modifier: Modifier = Modifier) {
    Text(
        text = "Привет, $group",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LabWorkTheme {
        Greeting("ИСПП-34,45")
    }
}

@Preview(showBackground = true)
@Composable
fun Task2Column(){
    Column {
        Text("Добро пожаловать")
        Button(onClick = { }, modifier = Modifier) { }
    }
}

@Preview(showBackground = true)
@Composable
fun Task2Row(){
    Row {
        Text("Добро пожаловать")
        Button(onClick = { }, modifier = Modifier) { }
    }
}

@Preview(showBackground = true)
@Composable
fun Task2Box(){
    Box {
        Text("Добро пожаловать")
        Button(onClick = { }, modifier = Modifier) { }
    }
}

/*@Preview(showBackground = true)
@Composable
fun Task3Box(){
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier) {
            Row(modifier = Modifier.background(Color.Red)) {

            }
            Row(modifier = Modifier
                .background(Color.Red)) {

            }
            Row(modifier = Modifier
                .background(Color.Red)) {

            }
            Row(modifier = Modifier
                .background(Color.Red)) {

            }
            Row(modifier = Modifier
                .background(Color.Red)) {

            }
        }
        Column(modifier = Modifier) {
            Row(modifier = Modifier.background(Color.Red)) {

            }
            Row(modifier = Modifier
                .background(Color.Red)) {

            }
            Row(modifier = Modifier
                .background(Color.Red)) {

            }
            Row(modifier = Modifier
                .background(Color.Red)) {

            }
            Row(modifier = Modifier
                .background(Color.Red)) {

            }
        }
        Column(modifier = Modifier) {
            Row(modifier = Modifier.background(Color.Red)) {

            }
            Row(modifier = Modifier
                .background(Color.Red)) {

            }
            Row(modifier = Modifier
                .background(Color.Red)) {

            }
            Row(modifier = Modifier
                .background(Color.Red)) {

            }
            Row(modifier = Modifier
                .background(Color.Red)) {

            }
        }
        Column(modifier = Modifier) {
            Row(modifier = Modifier.background(Color.Red)) {

            }
            Row(modifier = Modifier
                .background(Color.Red)) {

            }
            Row(modifier = Modifier
                .background(Color.Red)) {

            }
            Row(modifier = Modifier
                .background(Color.Red)) {

            }
            Row(modifier = Modifier
                .background(Color.Red)) {

            }
        }
    }
}*/

@Preview(showBackground = true)
@Composable
fun Task3Box() {
    Box(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .size(100.dp)
            .align(Alignment.TopStart)
            .background(Color.Red)){
        }
        Box(modifier = Modifier
            .size(100.dp)
            .align(Alignment.TopCenter)
            .background(Color(20, 200, 255))){
        }
        Box(modifier = Modifier
            .size(100.dp)
            .align(Alignment.TopEnd)
            .background(Color(255, 165, 0))){
        }
        Box(modifier = Modifier
            .size(100.dp)
            .align(Alignment.CenterStart)
            .background(Color.Green)){
        }
        Box(modifier = Modifier
            .size(100.dp)
            .align(Alignment.CenterEnd)
            .background(Color(255, 200, 255))){
        }
        Box(modifier = Modifier
            .size(100.dp)
            .align(Alignment.BottomStart)
            .background(Color(128, 0, 255))){
        }
        Box(modifier = Modifier
            .size(100.dp)
            .align(Alignment.BottomCenter)
            .background(Color.Gray)){
        }
        Box(modifier = Modifier
            .size(100.dp)
            .align(Alignment.BottomEnd)
            .background(Color.Yellow)){
        }
        Box(modifier = Modifier
            .width(300.dp)
            .height(700.dp)
            .align(Alignment.Center)
            .background(Color.Black)){
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Task3Column(){
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .weight(5f)
            .background(Color.Red)){
            Text("5%", color = Color.White)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .weight(15f)
            .background(Color.Green)){
            Text("15%")
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .weight(30f)
            .background(Color.Blue)){
            Text("30%", color = Color.White)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .weight(50f)
            .background(Color.Yellow)){
            Text("50%")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Task5(){
    var list = mutableListOf<String>("1", "2", "3", "4", "5")
    Column() {
        for (i in 0..list.size) {
            Text(list[i])
        }
    }
}