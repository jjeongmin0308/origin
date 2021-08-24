package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ContextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context)


        val context : Context = this // 자식은 부모의 타입이 될 수 있다.

        val applicationContext = getApplicationContext() as ContextActivity


    }
}