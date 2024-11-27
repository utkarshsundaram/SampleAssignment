package com.example.SampleAppDemo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color

@Composable
fun CustomCard(content: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 8.dp)
            .background(Color.White),
        elevation = CardDefaults.elevatedCardElevation(),
        shape = RoundedCornerShape(12.dp),
        colors = CardColors(
            containerColor = Color(0xFFD3D3D3),
            contentColor = Color.Black,
            disabledContentColor = Color.White,
            disabledContainerColor = Color.White
        )
    ) {
        Spacer(Modifier.padding(bottom = 8.dp))
        Text(
            text = content,
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Start
        )
    }
}
