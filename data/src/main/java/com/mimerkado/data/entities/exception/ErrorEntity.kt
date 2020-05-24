package com.mimerkado.data.entities.exception

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ErrorEntity(

    @SerializedName("error")
    val error: String?=null,
    @SerializedName("mensaje")
    val mensaje: String?=null

): Serializable