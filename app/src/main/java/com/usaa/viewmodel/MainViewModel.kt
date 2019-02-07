package com.usaa.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.usaa.model.RedditModel
import com.usaa.service.ProjectRepository

class MainViewModel : ViewModel() {

    val liveDataObserver: MutableLiveData<RedditModel> = ProjectRepository.loadData()
}
