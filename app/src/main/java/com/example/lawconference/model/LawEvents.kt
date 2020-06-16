package com.example.lawconference.model


data class LawEvents(
    var eventLocation: String,
    var eventTitle: String,
    var rating: String,
    var image: Int,
    var liked: Boolean = false,
    var id:Int=1
)
