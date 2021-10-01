package com.example.anushmp.coldstarmovieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MovieDetailActivity : AppCompatActivity() {

    lateinit var posterholder: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        posterholder = findViewById(R.id.posterholder)

        posterholder.setOnClickListener {

            var i = Intent(this,PosterViewActivity::class.java)
            startActivity(i)

        }

    }
}