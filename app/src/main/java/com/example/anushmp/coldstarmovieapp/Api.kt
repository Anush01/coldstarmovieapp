package com.example.anushmp.coldstarmovieapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("movie")
    fun getposters(@Query("api_key")apikey:String, @Query("query")name:String): Call<Response>

}