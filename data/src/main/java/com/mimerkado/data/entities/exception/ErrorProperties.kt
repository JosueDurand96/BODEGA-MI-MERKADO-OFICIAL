package com.mimerkado.data.entities.exception


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ErrorProperties(

    @SerializedName("tag")
    val tag: String,

    @SerializedName("title")
    val title: String

): Serializable
