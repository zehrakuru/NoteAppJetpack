package com.example.noteapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.noteapp.ui.home.NotesEvent
import com.example.noteapp.ui.home.NotesViewModel
import com.example.noteapp.ui.home.components.OrderSection
import com.example.noteapp.ui.navigation.NavigationBottomBar
import com.example.noteapp.ui.navigation.NoteAppNavHost
import com.example.noteapp.ui.theme.NoteAppTheme
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = {
                            NavigationBottomBar(navController)
                        },
                        topBar = {
                            CenterAlignedTopAppBar(
                                title = {
                                    Text(
                                        text = "My Notes",
                                        fontSize = 28.sp,
                                        color = Color.White
                                    )
                                },
                                actions = {
                                    IconButton(
                                        onClick = {
                                            NotesViewModel().onEvent(NotesEvent.ToggleOrderSection)
                                        }
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Sort,
                                            contentDescription = "Sort"
                                        )
                                    }
                                    AnimatedVisibility(
                                        visible = NotesViewModel().state.value.isOrderSectionVisible,
                                        enter = fadeIn() + slideInVertically(),
                                        exit = fadeOut() + slideOutVertically()
                                    ) {
                                        OrderSection(
                                            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
                                            noteOrder = NotesViewModel().state.value.noteOrder,
                                            onOrderChange = {
                                                NotesViewModel().onEvent(NotesEvent.Order(it))
                                            }
                                        )
                                    }
                                },
                                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(255, 204, 255) )
                            )
                        }
                    ) {

                        NoteAppNavHost(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(it),
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteAppTheme {
        Greeting("Android")
    }
}