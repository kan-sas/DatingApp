package com.ubersoftink.datingapp.data.models

import com.google.gson.annotations.SerializedName

data class CatResponse(
    val id : String,
    @SerializedName("url")
    val picUrl : String,
    val width: Int,
    val height: Int,
)
