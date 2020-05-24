package com.mimerkado.data.entities.register

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RegisterEntity(
    @SerializedName("error")
    var error:Boolean ?,
    @SerializedName("mensaje")
    var mensaje:String?
):Serializable