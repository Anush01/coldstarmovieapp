package com.example.anushmp.coldstarmovieapp

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Networker {

    var baseurl: String = "https://api.themoviedb.org/3/search/"

    companion object {

        var baseurl: String = "https://api.themoviedb.org/3/search/"

        fun getRetrofit(): Retrofit {

            return Retrofit.Builder().baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().build())
                .build()

        }

    }



}