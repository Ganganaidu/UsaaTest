package com.usaa.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.usaa.model.RedditModel
import com.usaa.service.ApiService
import com.usaa.service.ProjectRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainViewModel : ViewModel() {
    val liveData = MutableLiveData<RedditModel>()

    //loading data from server and attaching that data to live data observer
    fun loadData() {
        val liveData = MutableLiveData<RedditModel>()
        val dataApiService = ProjectRepository.retrofit().create(ApiService::class.java)

        dataApiService.redditData.enqueue(object : Callback<RedditModel> {
            override fun onResponse(call: Call<RedditModel>, response: Response<RedditModel>) {
                liveData.value = response.body()
            }

            override fun onFailure(call: Call<RedditModel>, t: Throwable) {
                liveData.value = null
            }
        })
    }

    //optional
    fun loadObserverData() {
        val liveData = MutableLiveData<RedditModel>()
        val dataApiService = ProjectRepository.retrofit().create(ApiService::class.java)
        dataApiService.rxRedditData
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                liveData.value = it
            }, {
                liveData.value = null
            })
    }
}
