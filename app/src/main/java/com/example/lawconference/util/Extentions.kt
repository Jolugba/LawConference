package com.example.lawconference.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.Toast

fun Activity.showToast(message:String){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}
    inline fun<reified T :Activity> Context.openActivity(block:Intent.()->Unit={}){
    val intent=Intent(this,T::class.java)
    block(intent)
    startActivity(intent)
}