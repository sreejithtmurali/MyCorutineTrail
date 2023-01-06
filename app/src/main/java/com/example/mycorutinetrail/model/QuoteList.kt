package com.example.mycorutines.model

data class QuoteList(val count: Int,
                     val lastItemIndex: Int,
                     val page: Int,
                     val results: List<Result>,
                     val totalCount: Int,
                     val totalPages: Int)


data class ErrorMsg(val errorCode:Int,val errorMsg:String)
