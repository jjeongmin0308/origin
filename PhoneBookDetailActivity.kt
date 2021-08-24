package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PhoneBookDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_detail)

        getPersonInfoAndDraw()

        val back : ImageView = findViewById(R.id.back)
        back.setOnClickListener {
            onBackPressed()
        }
    }

    fun getPersonInfoAndDraw() {
        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")

        val person_detail_name : TextView = findViewById(R.id.person_detail_name)
        val person_detail_number : TextView = findViewById(R.id.person_detail_number)

        person_detail_name.setText(name)
        person_detail_number.setText(number)

    }
}