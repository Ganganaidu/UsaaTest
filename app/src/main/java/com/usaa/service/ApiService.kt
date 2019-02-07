package com.usaa.service

import com.usaa.model.RedditModel

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @get:GET("androiddev.json")
    val redditData: Call<RedditModel>

    companion object {
        const val BASE_URL = "https://www.reddit.com/r/"
    }
}
