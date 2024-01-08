package com.example.noteapp.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapp.R

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize().background(color = Color(255, 204, 255)),
        contentAlignment = Alignment.Center
    ) {
        Text(modifier = Modifier
            .padding(top = 130.dp)
            .align(Alignment.Center),
            text = "Create your first note!",
            fontSize = 20.sp,
            color = Color.White)
        Image(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(id = R.drawable.note),
            contentDescription = null,
        )
        Fab()
    }
}

@Composable
fun Fab() {
    FloatingActionButton(
        onClick = { /* Handle FAB click here */ },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .wrapContentSize(align = Alignment.BottomEnd),
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = Color(255, 204, 255),
        shape = CircleShape
    ) {
        Icon(
            imageVector = Icons.Rounded.Add,
            contentDescription = "Fab Button",
        )
    }
}