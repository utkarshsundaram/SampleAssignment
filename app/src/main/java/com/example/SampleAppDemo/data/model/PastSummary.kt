package com.example.SampleAppDemo.data.model

data class PastSummary(
    val id: String,
    val createdAt: String,
    val quote: String,
    val emotions: List<Emotion>,
    val highlights: List<String>
)
