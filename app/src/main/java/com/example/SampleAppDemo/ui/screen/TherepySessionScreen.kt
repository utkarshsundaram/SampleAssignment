package com.example.SampleAppDemo.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
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
import com.example.SampleAppDemo.data.model.repository.DataRepository
import com.example.SampleAppDemo.ui.charts.PieChartView
import com.example.SampleAppDemo.ui.components.ShareableQuote
import com.example.SampleAppDemo.R
import com.example.SampleAppDemo.data.model.Conversation
import com.example.SampleAppDemo.ui.components.HighlightsSection
import com.example.SampleAppDemo.ui.components.TopBar

@SuppressLint("SuspiciousIndentation")
@Composable
fun TherapySessionScreen(conversation: Conversation) {
        Box(
            modifier = Modifier.fillMaxHeight()
        ) {
            Image(
                painter = painterResource(id = R.drawable.background_images),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())

            ) {
                TopBar()
                ContentSection(conversation)
                Box(
                    modifier = Modifier.fillMaxSize()
                ){
                    Button(
                        onClick = {  },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Green
                        ),
                        modifier = Modifier.align(Alignment.Center)
                            .padding(horizontal = 8.dp, vertical = 8.dp)
                            .padding(50.dp)
                    ) {
                        Text("Continue Session", style = MaterialTheme.typography.displaySmall, color = Color.Black)
                    }
                }

            }
        }
}

@Composable
fun ContentSection(conversation: Conversation) {
    Text(
        text = conversation.title,
        style = MaterialTheme.typography.displayMedium,
        color = Color.White,
        modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
    )
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = { },
            modifier = Modifier.weight(1f).padding(start = 16.dp, end = 8.dp).border(
                width = 2.dp,
                color = Color.White,
                shape = MaterialTheme.shapes.medium // Use rounded corners or any shape
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            elevation = ButtonDefaults.buttonElevation()
        ) {
            Text("Past Summaries", style = MaterialTheme.typography.labelSmall)
        }
        Button(
            onClick = { },
            modifier = Modifier.weight(1f).padding(end = 8.dp).border(
                width = 2.dp,
                color = Color.White,
                shape = MaterialTheme.shapes.medium
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            elevation = ButtonDefaults.buttonElevation()
        ) {
            Text("Continue Session", style = MaterialTheme.typography.labelSmall)
        }
    }
    conversation.pastSummaries.forEach { summary ->
        Column(modifier = Modifier.fillMaxWidth().wrapContentHeight()) {
            ShareableQuote(
                quote = summary.quote,
            )
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .wrapContentHeight()
                .padding(16.dp),
            elevation = CardDefaults.elevatedCardElevation(),
            shape = MaterialTheme.shapes.medium,
            border = BorderStroke(4.dp, Color.White),
        ) {
            PieChartView(emotions = summary.emotions, modifier = Modifier.height(300.dp))
            summary.emotions.forEach { emotion ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "${emotion.name}: ${emotion.value}%",
                        style = MaterialTheme.typography.displaySmall,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)) {
            HighlightsSection(summary)
        }
    }
}


