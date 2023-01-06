package com.example.mycorutines.screens.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope

class MainViewModel:ViewModel() {
    val repo= Repo()

    fun myApi()= liveData {
        emitSource(repo.myApi().asLiveData(viewModelScope.coroutineContext))
    }





}