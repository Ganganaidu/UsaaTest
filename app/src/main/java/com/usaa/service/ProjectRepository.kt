package com.usaa.service

import android.arch.lifecycle.MutableLiveData

import com.usaa.model.RedditModel

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ProjectRepository {

    private val dataApiService: ApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        dataApiService = retrofit.create(ApiService::class.java)
    }

    //loading data from server and attaching that data to live data observer
    fun loadData(): MutableLiveData<RedditModel> {
        val liveData = MutableLiveData<RedditModel>()
        dataApiService.redditData.enqueue(object : Callback<RedditModel> {
            override fun onResponse(call: Call<RedditModel>, response: Response<RedditModel>) {
                liveData.value = response.body()
            }

            override fun onFailure(call: Call<RedditModel>, t: Throwable) {
                liveData.value = null
            }
        })
        return liveData
    }
}
