package com.example.anushmp.coldstarmovieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton

class MovieDetailActivity : AppCompatActivity() {

    lateinit var posterholder: ImageView
    lateinit var showtrailer:MaterialButton
    lateinit var movietitle:String
    lateinit var overview:String
    lateinit var releasedate:String
    lateinit var movietitleholder:TextView
    lateinit var moviedescriptionholder: TextView
    lateinit var releasedateholder: TextView
    lateinit var posterurl: String
    lateinit var bigposterurl: String
    lateinit var playmoviebutton: MaterialButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        posterholder = findViewById(R.id.posterholder)
        showtrailer = findViewById(R.id.showtrailer)

        movietitleholder = findViewById(R.id.movieTitleHolder)
        moviedescriptionholder = findViewById(R.id.descriptionholder)
        releasedateholder = findViewById(R.id.ReleaseDateholder)
        playmoviebutton = findViewById(R.id.playmovie)

        movietitle = intent.getStringExtra("title").toString()
        overview = intent.getStringExtra("overview").toString()
        releasedate = intent.getStringExtra("releasedate").toString()
        posterurl = intent.getStringExtra("posterurl").toString()
        bigposterurl = intent.getStringExtra("bigposterurl").toString()

        movietitleholder.text = movietitle
        moviedescriptionholder.text = overview
        releasedateholder.append(releasedate)

        Glide.with(this).load(posterurl).placeholder(R.drawable.ic_launcher_background).into(posterholder)

        posterholder.setOnClickListener {

            var i = Intent(this,PosterViewActivity::class.java)
            i.putExtra("bigposterurl",bigposterurl)
            startActivity(i)

        }


        showtrailer.setOnClickListener {

            var totrailer: Intent = Intent(this,TrailerViewActivity::class.java)

            totrailer.putExtra("title",movietitle)

            startActivity(totrailer)

        }


        playmoviebutton.setOnClickListener {

            var toMovie: Intent = Intent(this,PlayMovieActivity::class.java)

            toMovie.putExtra("title", movietitle)
            toMovie.putExtra("overview",overview)
            toMovie.putExtra("releasedate",releasedate)

            startActivity(toMovie)
            //internal working fundamentals.

        }




    }
}