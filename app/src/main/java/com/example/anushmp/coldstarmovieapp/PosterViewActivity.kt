package com.example.anushmp.coldstarmovieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide

class PosterViewActivity : AppCompatActivity() {

lateinit var posterview:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poster_view)


        posterview = findViewById(R.id.posterfull)

        var bigposter = intent.getStringExtra("bigposterurl")

        if (bigposter != null) {
            Log.d("bigposter",bigposter)
        }

        Glide.with(this).load(bigposter).placeholder(R.drawable.ic_launcher_background).into(posterview)

    }
}