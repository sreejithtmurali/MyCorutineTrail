package com.example.mycorutines.web

import com.example.mycorutines.model.QuoteList
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/quotes")
    suspend fun getQuotes() : Response<QuoteList>
}