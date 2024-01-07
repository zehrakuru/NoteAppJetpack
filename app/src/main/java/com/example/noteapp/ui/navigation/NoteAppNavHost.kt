package com.example.noteapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.noteapp.ui.done.DoneScreen
import com.example.noteapp.ui.home.HomeScreen

@Composable
fun NoteAppNavHost(
    modifier: Modifier,
    navController: NavHostController
) {
    NavHost(modifier = modifier,
        navController = navController,
        startDestination = "home" ) {
        composable("home") {
            HomeScreen()
        }
        composable("done") {
            DoneScreen()
        }
    }
}

