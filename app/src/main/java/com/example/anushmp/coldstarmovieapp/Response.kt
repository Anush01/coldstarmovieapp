package com.example.anushmp.coldstarmovieapp

import com.google.gson.annotations.SerializedName

data class Response (

    @SerializedName("page") val page : Int,
    @SerializedName("results") val results : List<Results>,
    @SerializedName("total_pages") val total_pages : Int,
    @SerializedName("total_results") val total_results : Int
)