package com.mimerkado.data.entities.register

import com.google.gson.annotations.SerializedName
import com.mimerkado.data.entities.register.RegisterEntity
import java.io.Serializable

data class RegisterMasterEntity (
    @SerializedName("registerEntity")
    var registerEntity: RegisterEntity?
): Serializable