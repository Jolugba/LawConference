package com.example.lawconference.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lawconference.R
import kotlinx.android.synthetic.main.activity_event_detail.*

class EventDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)


        itemTitle.text = intent.getStringExtra("itemTitle")
        itemLocation.text = intent.getStringExtra("itemLocation")
        itemRating.text = intent.getStringExtra("itemRating")
        itemImage.setImageResource(intent.getStringExtra("itemImage").toInt())
    }
}