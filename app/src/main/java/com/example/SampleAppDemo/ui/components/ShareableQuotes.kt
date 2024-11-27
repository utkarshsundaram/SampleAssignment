package com.example.SampleAppDemo.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.SampleAppDemo.R

@Composable
fun ShareableQuote(quote: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .wrapContentHeight()
            .padding(16.dp),
        elevation = CardDefaults.elevatedCardElevation(),
        shape = MaterialTheme.shapes.medium,
        border = BorderStroke(2.dp, Color.White)
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.background_share_image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center, // Center the text vertically
                horizontalAlignment = Alignment.CenterHorizontally // Center the text horizontally
            ) {
                Text(
                    text = quote,
                    style = MaterialTheme.typography.displayLarge,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 16.dp) // Space for the button
                )

                Button(
                    onClick = { },
                    modifier = Modifier.padding(end = 8.dp).border(
                        width = 2.dp,
                        color = Color.Black,
                        shape = MaterialTheme.shapes.medium
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    elevation = ButtonDefaults.buttonElevation()
                ) {
                    Text("Share", style = MaterialTheme.typography.labelSmall, color = Color.Black)
                }
            }
        }
    }
}
