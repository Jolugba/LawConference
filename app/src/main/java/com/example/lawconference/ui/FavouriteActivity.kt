package com.example.lawconference.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lawconference.R
import com.example.lawconference.util.openActivity
import kotlinx.android.synthetic.main.activity_favourite.*

class FavouriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)


        addFavouriteButton.setOnClickListener {
            openActivity<MainActivity> { }

        }
    }
}