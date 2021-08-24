package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class Intent2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent2)

        val number1 = intent.getIntExtra("number1", 0)
        val number2 = intent.getIntExtra("number2", 0)

        Log.d("number", "" +number1)
        Log.d("number2", "" +number2)

        val result: Button = findViewById(R.id.result)

        result.setOnClickListener{
            val number1 = intent.getIntExtra("number1", 0)
            val number2 = intent.getIntExtra("number2", 0)

            Log.d("number", "" +number1)
            Log.d("number2", "" +number2)

            val result = number1 + number2
            val resultIntent = Intent()
            resultIntent.putExtra("result", result)
            setResult(Activity.RESULT_OK, resultIntent)
            finish() // -> Activity 종료

            //Stack
            //Intent 2 -> 종료
            //Intent 1             Intent1
        }
    }
}