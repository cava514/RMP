package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.provider.FontsContractCompat
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BoxScreen()
            LazyVerticalGridScreen()
        }
    }
}


@Composable
fun BoxScreen(){
    Box(Modifier.size(300.dp, 400.dp),
        contentAlignment = Alignment.Center){
        Text("Привет", fontSize = 28.sp,
            modifier = Modifier.align(Alignment.TopStart))
        Text("Пока", fontSize = 28.sp,
            modifier = Modifier.align(Alignment.BottomEnd))
    }
}

@Preview(showBackground = true)
@Composable
fun ColumnScreen() {
    Column(Modifier.size(300.dp, 400.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally){
        listOf("Артем", "Тимофей", "Савелий", "Алина", "Даниэла", "Кирилл")
            .forEach {
                Text(it, fontSize = 28.sp)
            }
    }
}

@Preview(showBackground = true)
@Composable
fun ColumnWeightScreen() {
    Column(Modifier.size(300.dp, 400.dp)){
        Box(Modifier.background(Color.Blue).fillMaxWidth()
            .weight(1f))
        Box(Modifier.background(Color.Blue).fillMaxWidth()
            .weight(2f))
        Box(Modifier.background(Color.Blue).fillMaxWidth()
            .weight(3f))
    }
}

@Preview(showBackground = true)
@Composable
fun RowScreen() {
    Row(Modifier.size(300.dp, 100.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically){
        listOf("Артем", "Тимофей", "Савелий", "Алина", "Даниэла", "Кирилл")
            .forEach {
                Text(it, fontSize = 28.sp)
            }
    }
}

@Preview(showBackground = true)
@Composable
fun SurfaceScreen(){
    Surface(modifier = Modifier.size(300.dp),
        color = Color.LightGray,
        contentColor = Color.DarkGray
        ) {
        Text("Привет Артем", fontSize = 30.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun LazyColumnScreen(){
    val students = listOf("Артем", "Тимофей", "Савелий", "Алина", "Даниэла", "Кирилл")
    LazyColumn(
        Modifier.size(300.dp, 400.dp)
    ) {
        item { Text("Любимые студенты", fontSize = 48.sp) }
        itemsIndexed(students){ i, student ->
            Text(student, fontSize = 28.sp,
                modifier = Modifier.background(
                    if (i%2==0) Color.LightGray else Color.White
                ))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyVerticalGridScreen(){
    LazyVerticalGrid( columns = GridCells.Fixed(3),
        modifier = Modifier.size(300.dp, 400.dp)
    ) {
        items(50){
            Box(Modifier.fillMaxWidth()
                .height(100.dp)
                .background(Color(
                    Random.nextInt(255),
                    Random.nextInt(255),
                    Random.nextInt(255),
                ))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyVerticalStaggeredGridScreen(){
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(3),
        modifier = Modifier.size(300.dp, 400.dp)
    ) {
        items(50){
            Box(Modifier.fillMaxWidth()
                .height(Random.nextInt(10, 100).dp)
                .background(Color(
                    Random.nextInt(255),
                    Random.nextInt(255),
                    Random.nextInt(255)
                ))
            ){
                Text(it.toString())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FlowRowScreen(){
    FlowRow(
        modifier = Modifier.size(300.dp, 400.dp)
    ) {
        val students = listOf("Артем", "Тимофей", "Савелий", "Алина", "Даниэла", "Кирилл")
        students.forEach {
            Text(it, fontSize = 28.sp,
                modifier = Modifier
                    .padding(5.dp)
                    .background(Color.LightGray)
                    .padding(5.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyColumnScrollScreen(){
    val students = listOf("Артем", "Тимофей", "Савелий", "Алина", "Даниэла", "Кирилл", "Артем", "Тимофей", "Савелий", "Алина", "Даниэла", "Кирилл", "Артем", "Тимофей", "Савелий", "Алина", "Даниэла", "Кирилл")
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    LazyColumn(
        Modifier.padding(0.dp, 100.dp).fillMaxSize(),
        listState
    ) {
        stickyHeader { Text("В конец", fontSize = 28.sp,
            modifier = Modifier.background(Color.Red).clickable{
                coroutineScope.launch {
                    listState.animateScrollToItem(20)
                }
            }) }
        itemsIndexed(students){ i, student ->
            Text("$i $student", fontSize = 28.sp,
                modifier = Modifier.background(
                    if (i%2==0) Color.LightGray else Color.White
                ))
        }
    }
}