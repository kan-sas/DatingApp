package com.ubersoftink.datingapp.data.models

import kotlinx.serialization.Serializable

@Serializable
data class CatResponse(
    val id : String,
    val url : String,
    val width: Int,
    val height: Int,
)
