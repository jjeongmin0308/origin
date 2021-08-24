package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)


        val button : Button = findViewById(R.id.change_activity)


        button.setOnClickListener {
    //        val Intent = Intent(this@Intent1, Intent2::class.java)

            // Key, Value 방식 -> Key와 value를 쌍으로 만들어 저장 -> Dictionary
    //        intent.putExtra("number1", 1)
    //        intent.putExtra("number2", 2)
    //        startActivity(Intent)

            val Intent2 = Intent(this@Intent1, Intent2::class.java)

            // Apply
    //        Intent2.apply {
    //            this.putExtra("number1", 1)
    //            this.putExtra("number2", 2)

    //        }
    //        startActivityForResult(Intent2, 200)

            // 암시적 인텐트
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://naver.com") )
            startActivity(intent)


        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == 20) {
            Log.d("number", "" +requestCode)
            Log.d("number", "" + resultCode)
            val result = data?.getIntExtra("result", 0)
            Log.d("number", ""+result)
        }


        super.onActivityResult(requestCode, resultCode, data)
    }
}
