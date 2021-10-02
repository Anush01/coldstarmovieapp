package com.example.anushmp.coldstarmovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class PlayMovieActivity : AppCompatActivity() {

    lateinit var youtubeplayerview: YouTubePlayerView
    lateinit var movietitle:TextView
    lateinit var moviedescription:TextView
    lateinit var releasedate:TextView
    lateinit var watchlistbutton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_movie)

        youtubeplayerview = findViewById(R.id.youtube_player_view)

        lifecycle.addObserver(youtubeplayerview)

        movietitle = findViewById(R.id.playingmovietitle)
        moviedescription = findViewById(R.id.playingmoviedescription)
        releasedate = findViewById(R.id.releasedateplay)
        watchlistbutton = findViewById(R.id.addtowatchist)
        //sell


        movietitle.text = intent.getStringExtra("title")
        moviedescription.text = intent.getStringExtra("overview")
        releasedate.text = intent.getStringExtra("releasedate")




    }


    override fun onDestroy() {
        super.onDestroy()

        youtubeplayerview.release()

    }

}