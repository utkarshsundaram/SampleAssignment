package com.example.SampleAppDemo.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 0.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /* Handle back button click */ }) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back",tint = Color.White)
        }

        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = { /* Handle menu button click */ }) {
            Icon(Icons.Default.MoreVert, contentDescription = "Menu",tint = Color.White)
        }

        IconButton(onClick = { /* Handle another action button click */ }) {
            Icon(Icons.Default.Info, contentDescription = "Info",tint = Color.White)
        }
    }
}