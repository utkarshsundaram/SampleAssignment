package com.example.SampleAppDemo.data.model

data class Conversation(
    val id: String,
    val title: String,
    val createdAt: String,
    val updatedAt: String,
    val pastSummaries: List<PastSummary>
)
