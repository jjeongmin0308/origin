package com.example.myapplication

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Resource : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        //1
        val ment = resources.getString(R.string.hello)
        Log.d("mentt", "ment: " +ment)

        //2
        var ment2 = getString(R.string.hello)
        Log.d("ment", "ment: " + ment2)

        // SDK 버전에 따른 분기 처리
        val button : Button = findViewById(R.id.button)
        val color = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            button.setBackgroundColor(getColor(R.color.textview_color))
        } else {
            button.setBackgroundColor(resources.getColor(R.color.textview_color))
        }


    }
}