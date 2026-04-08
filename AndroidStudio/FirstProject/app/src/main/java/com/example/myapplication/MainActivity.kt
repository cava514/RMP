package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ScaleFactor
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Greeting()
        }
    }
}

@Composable
fun Greeting() {
    MyApplicationTheme {
        Scaffold(Modifier.fillMaxSize()) { innerPadding ->
            Column (Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
            ) {
                var n = -5;

                for (i in 1..100){
                    Text("Привет ИСПП ${i}",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(5.dp)
                            .shadow(7.dp, CircleShape)
                            .clickable(onClick = {})
                            .padding(10.dp)
                            .background(Color.Red, CircleShape)
                            //.width(200.dp)
                            //.height(100.dp)
                            .size(100.dp)
                            .border(2.dp, Color.Black, CircleShape)
                    )
                }

                Box(modifier = Modifier
                    //.offset(100.dp, 100.dp)
                    .size(100.dp)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .background(Color.Blue)
                    .padding(10.dp)
                    .background(Color.Green)
                )

                Text1(Modifier.background(Color.Blue))

                if (n>0){
                    TextField("qwe",{})

                }
            }
        }
    }
}

@Composable
fun Text1(modifier: Modifier = Modifier){
    Text(text = "123", modifier = Modifier
        .padding(5.dp)
        .then(modifier))
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Greeting()
}