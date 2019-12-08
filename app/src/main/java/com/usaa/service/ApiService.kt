package com.usaa.service

import com.usaa.model.RedditModel

import retrofit2.Call
import retrofit2.http.GET
import rx.Observable

interface ApiService {
    @get:GET("androiddev.json")
    val redditData: Call<RedditModel>

    @get:GET("androiddev.json")
    val rxRedditData: Observable<RedditModel>
}
