package com.example.anushmp.coldstarmovieapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity: AppCompatActivity() {

    var splashtask: Runnable = Runnable {





            var i: Intent = Intent(this, MainActivity::class.java)

            startActivity(i)

            finish()






    }

    lateinit var splashhandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreenlayout)


        splashhandler = Handler(Looper.myLooper()!!)

        splashhandler.postDelayed(splashtask,2000)




    }


}