package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class LibraryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        val glide : ImageView = findViewById(R.id.glide)
        Glide.with(this@LibraryActivity)
            .load("https://w.namu.la/s/0c6301df01fc4f180ec65717bad3d0254258abf0be33299e55df7c261040f517518eb9008a1a2cd3d7b8b7777d70182c185bc891b1054dc57b11cc46fd29130a81d73003803c6b7337bb883344b61699c02c8f23007d4c0f2e83a86841875a96")
            .centerCrop()
            .into(glide)

        val glide2 : ImageView = findViewById(R.id.glide2)
        Glide.with(this@LibraryActivity)
            .load("https://w.namu.la/s/0c6301df01fc4f180ec65717bad3d0254258abf0be33299e55df7c261040f517518eb9008a1a2cd3d7b8b7777d70182c185bc891b1054dc57b11cc46fd29130a81d73003803c6b7337bb883344b61699c02c8f23007d4c0f2e83a86841875a96")
            .into(glide2)

    }
}