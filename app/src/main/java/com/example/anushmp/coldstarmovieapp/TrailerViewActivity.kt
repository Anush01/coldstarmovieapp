package com.example.anushmp.coldstarmovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class TrailerViewActivity : AppCompatActivity() {

    var baseurl = "https://m.youtube.com/results?sp=mAEA&search_query="
    lateinit var query: String
    lateinit var trailerview: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trailer_view)

        trailerview = findViewById(R.id.TrailerView)

        trailerview.webViewClient= WebViewClient()

        var demooriginaltitle:String = "The Avengers Endgame"

        if(intent.getStringExtra("title") != null){

            demooriginaltitle = intent.getStringExtra("title")!!

        }

        var trailerword = " trailer"

        var combine1 = demooriginaltitle + trailerword


        combine1.replace("\\s".toRegex(),"-")
        //The-Avengers-Endgame-trailer

        //var trailerword = " tailer"

        query = combine1



        var completeurl: String = baseurl + query

        trailerview.apply {

            loadUrl(completeurl)
            settings.javaScriptEnabled = true
        }



    }
}