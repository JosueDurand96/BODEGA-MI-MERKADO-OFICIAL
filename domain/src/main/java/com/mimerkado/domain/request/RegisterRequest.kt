package com.mimerkado.domain.request

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class RegisterRequest (
    @SerializedName("nombres_apellidos")
    var nombres_apellidos: String? = null,
    @SerializedName("apellidos")
    var apellidos: String? = null,
    @SerializedName("celular")
    var celular: String? = null,
    @SerializedName("dni")
    var dni: String? = null,
    @SerializedName("correo")
    var correo:String?=null,
    @SerializedName("password")
    var password:String?=null,
    @SerializedName("estado")
    var estado:String?=null

):Serializable
