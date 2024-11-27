package com.example.SampleAppDemo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.SampleAppDemo.data.model.repository.DataRepository
import com.example.SampleAppDemo.ui.screen.TherapySessionScreen
import com.example.SampleAppDemo.ui.theme.SampleAppDemoTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val conversation = DataRepository.getConversationResponse().conversation
        enableEdgeToEdge()
        setContent {
            SampleAppDemoTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    content = {
                        TherapySessionScreen(conversation)
                    }
                )
            }
        }
    }
}