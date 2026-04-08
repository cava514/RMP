package com.example.textelements

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.TextAutoSizeDefaults
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.textelements.ui.theme.TextElementsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    var text by remember { mutableStateOf("") }
    TextElementsTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(Modifier.padding(innerPadding)) {
                TextField(text,
                    { text = if (it.length>5) text else it },
                    label = { Text("Текст") },
                    placeholder = {Text("...") },
                    leadingIcon = { Icon(Icons.Filled.Check,
                            "Ok") },
                    trailingIcon = { Icon(Icons.Filled.Search,
                        "Search") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email))
                OutlinedTextField(text,
                    { text = it },
                    label = { Text("Текст") },
                    placeholder = { Text("...") },
                    leadingIcon = { Icon(Icons.Filled.Check,
                            "Ok") },
                    trailingIcon = {Icon(Icons.Filled.Search,
                            "Search") },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    singleLine = true,
                    maxLines = 3, minLines = 2,
                    colors = OutlinedTextFieldDefaults.colors())
                var isChecked by remember { mutableStateOf(true) }
                Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .selectable(isChecked) {isChecked = !isChecked}
                ){
                    Checkbox(isChecked,
                        {isChecked = it})
                    RadioButton(selected = isChecked, {isChecked = !isChecked})
                    Text("Установить мессенджер Max")
                }

                val students = listOf("Савелий", "Виктория", "Артем", "Алина", "Даниэла")
                var selected by remember { mutableStateOf(students[0]) }

                students.forEach{ student ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(selected == student,
                            {selected = student})
                        Text(student)
                    }
                }

                var length by remember { mutableStateOf(0.0f) }
                Slider(length, {length = it},
                    valueRange = 0f..100f, steps = 10)
            }
        }
    }
}