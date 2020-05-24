package com.mimerkado.data.entities.login


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LoginEntity(
    @SerializedName("cliente")
    var cliente: List<ClienteEntity> ?= arrayListOf()
): Serializable