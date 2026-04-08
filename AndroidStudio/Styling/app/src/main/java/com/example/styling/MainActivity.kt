package com.example.styling

import android.icu.text.CaseMap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.styling.ui.theme.AppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isDarkTheme by remember { mutableStateOf(true) }
            AppTheme(darkTheme = isDarkTheme) {
                val scope = rememberCoroutineScope()
                val snackBarHostState = remember { SnackbarHostState() }
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {Text("Крутое приложение")},
                            navigationIcon = {
                                IconButton({}) {
                                    Icon(Icons.AutoMirrored.Filled.ArrowBack,
                                        "Назад")
                                }
                            },
                            actions = {
                                IconButton({
                                    isDarkTheme = !isDarkTheme
                                }) {
                                    Icon(Icons.Filled.Menu,
                                        "")
                                }
                            }
                        )
                    },

                    bottomBar = {
//                        BottomAppBar(
//                            actions = {
//                                IconButton({}) {
//                                    Icon(Icons.Filled.Search,
//                                        "")
//                                }
//                                IconButton({}) {
//                                    Icon(Icons.Filled.Edit,
//                                        "")
//                                }
//                                IconButton({}) {
//                                    Icon(Icons.Filled.Settings,
//                                        "")
//                                }
//                            }
//                        )

                        NavigationBar {
                            NavigationBarItem(
                                selected = true,
                                onClick = {},
                                icon = {Icon(Icons.Filled.Search,
                                        "")}
                            )
                            NavigationBarItem(
                                selected = true,
                                onClick = {},
                                icon = {Icon(Icons.Filled.Edit,
                                        "")}
                            )
                            NavigationBarItem(
                                selected = true,
                                onClick = {},
                                icon = {Icon(Icons.Filled.Settings,
                                        "")}
                            )
                        }
                    },

                    floatingActionButton = {
                        ExtendedFloatingActionButton(
                            icon = {Icon(Icons.Filled.Phone,
                                "")},
                            text = {Text("Возьми телефон")},
                            onClick = {
                                scope.launch {
                                    val result = snackBarHostState
                                        .showSnackbar(
                                            message = "Привет",
                                            actionLabel = "Ок",
                                            withDismissAction = true,
                                            duration = SnackbarDuration.Short
                                        )
                                    when(result){
                                        SnackbarResult.Dismissed -> {}
                                        SnackbarResult.ActionPerformed -> {}
                                    }
                                }
                            }
                        )
                    },

                    floatingActionButtonPosition = FabPosition.Center,

                    snackbarHost = {
                        SnackbarHost(snackBarHostState)
                    },

                    modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    LazyColumn(modifier) {
        items(100){
            Card(Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(5.dp),
                shape = MaterialTheme.shapes.small,
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    contentColor = MaterialTheme.colorScheme.onTertiaryContainer)
            )
            {
                Text((it*1000000).toString(),
                    Modifier.padding(5.dp),
                    style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}