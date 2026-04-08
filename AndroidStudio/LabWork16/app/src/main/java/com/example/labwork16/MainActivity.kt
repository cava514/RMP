package com.example.labwork16

import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.labwork16.ui.theme.LabWork16Theme
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabWork16Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Main(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Main(modifier: Modifier = Modifier){
    Box(modifier = Modifier.fillMaxSize()){
        Row(modifier = Modifier.fillMaxWidth()) {
            Text("Main")
        }
        TextField(value = "", onValueChange = {},
            label = { stringResource(R.string.search) }
        )
        Button(onClick = {}) {
            Text(stringResource(R.string.menu))
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = ScrollState(0))){
        }
    }
}

val c = Calendar.getInstance()
val hour = c.get(Calendar.HOUR_OF_DAY)
val minute = c.get(Calendar.MINUTE)