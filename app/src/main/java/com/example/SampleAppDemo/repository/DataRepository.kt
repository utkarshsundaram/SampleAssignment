package com.example.SampleAppDemo.data.model.repository

import com.example.SampleAppDemo.data.model.ConversationResponse
import com.google.gson.Gson

object DataRepository {
    private val json = """ 
    {
      "conversation": {
        "id": "unique-conversation-id",
        "title": "Addressing Personal Concerns in Therapy",
        "createdAt": "2024-11-18T12:00:00Z",
        "updatedAt": "2024-11-18T14:00:00Z",
        "pastSummaries": [
          {
            "id": "unique-summary-id-1",
            "createdAt": "2024-11-18T12:15:00Z",
            "quote": "Keep shining; you're making remarkable progress.",
            "emotions": [
              {
                "name": "Joy",
                "value": 50.0,
                "color":"FFA726"
              },
              {
                "name": "Trust",
                "value": 25.0,
                "color":"29B6F6"
              },
              {
                "name": "Surprise",
                "value": 15.0,
                "color":"AB47BC"
              },
              {
                "name": "Fear",
                "value": 15.0,
                "color":"FF7043"
              },
              {
                "name": "Sadness",
                "value": 10.0,
                "color":"78909C"
              }
            ],
            "highlights": [
              "Maybe I could try to organize my tasks better and take some time off to relax.",
              "I think I'll start by making a list of all the tasks I need to do and then prioritize them.",
              "Yes, I think I might need to do that. Thank you for your support."
            ]
          }
        ]
      }
    }
    """

    fun getConversationResponse(): ConversationResponse {
        return Gson().fromJson(json, ConversationResponse::class.java)
    }
}