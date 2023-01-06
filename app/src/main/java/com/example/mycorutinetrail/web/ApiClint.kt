package com.example.mycorutines.web

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClint {

    val baseUrl = "https://quotable.io/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}