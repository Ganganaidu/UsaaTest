package com.usaa.model

import com.google.gson.annotations.SerializedName

class ChildData {

    @SerializedName("selftext")
    val selftext: String? = null

    @SerializedName("author_fullname")
    val authorFullname: String? = null

    @SerializedName("title")
    val title: String? = null

    @SerializedName("num_comments")
    val commentCount: Int = 0
}
