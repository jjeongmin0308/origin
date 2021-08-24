package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class Listner : AppCompatActivity() {

    var number = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listner) }

        // 뷰를 activity로 가져오는 방법
        // 1> 직접 찾아서 가져온다.
       val textView : TextView = findViewById(R.id.hello)
       val imageView : ImageView = findViewById(R.id.image)

        // 2> xml을 import해서 가져온다.



       // 3 -> 이름이 필요한 경우 (click)
        val click = object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("click", "Click!!")
                textView.setText("안녕하세요")
                imageView.setImageResource(R.drawable.girl)
                // hello.setText("안녕하세요")
                // image.setImageResource(R.drawable.girl)
                number += 10
                Log.d("number", "" + number)
            }

        //뷰를 조작하는 함수들

        // 1> setText
        // 2> SetImageResource




    }
}