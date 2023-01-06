package com.example.mycorutines.screens.main.home

import com.example.mycorutines.web.ApiClint
import com.example.mycorutines.web.ApiInterface
import kotlinx.coroutines.flow.flow

class Repo{

    fun myApi()= flow{
        val apiInterface = ApiClint.getInstance().create(ApiInterface::class.java)
        val result = apiInterface.getQuotes()
        if(result.isSuccessful)
        {
            emit(result.body())
        }



    }
}