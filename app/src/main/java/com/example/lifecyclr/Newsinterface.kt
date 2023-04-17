package com.example.lifecyclr

import com.example.lifecyclr.dataclass.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Newsinterface {

    @GET("v2/top-headlines")
    fun fetchHeadlines(@Query("country") country :String ,@Query("apiKey") apikey :String) : Call<News>
    //https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=60113f098af04a078c1e12fa02e66544
}