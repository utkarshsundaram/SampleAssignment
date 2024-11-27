package com.example.SampleAppDemo.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.SampleAppDemo.data.model.PastSummary

@Composable
fun HighlightsSection(summary: PastSummary) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .wrapContentHeight()
            .padding(4.dp),
        elevation = CardDefaults.elevatedCardElevation(),
        shape = MaterialTheme.shapes.medium,
        border = BorderStroke(2.dp, Color.White),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 16.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize() // Makes the Box take up the full available space
            ) {
                Text(
                    text = buildAnnotatedString {
                        append("Your ")
                        withStyle(style = SpanStyle(color = Color.Green)) {
                            append("Highlights")
                        }
                        append(" During the Session")
                    },
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(horizontal = 8.dp, vertical = 8.dp)
                )
            }
            Box(
                modifier = Modifier.fillMaxSize() // Makes the Box take up the full available space
            ) {
                Text(
                    text = "Let's take a closer look at your change talk from our conversation:",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.Center)
                        .padding(horizontal = 8.dp, vertical = 8.dp)
                )
            }

            Spacer(Modifier.padding(top = 8.dp, bottom = 8.dp))
            summary.highlights.forEach { highlight ->
                CustomCard(content = highlight)
            }
        }
    }
}