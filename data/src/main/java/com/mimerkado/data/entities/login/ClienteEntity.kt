package com.mimerkado.data.entities.login


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ClienteEntity(
    @SerializedName("celular")
    var celular: String? = null,
    @SerializedName("correo")
    var correo: String? = null,
    @SerializedName("dni")
    var dni: String? = null,
    @SerializedName("domicilio")
    var domicilio: String? = null,
    @SerializedName("estado")
    var estado: String? = null,
    @SerializedName("fecha_nacimiento")
    var fechaNacimiento: String? = null,
    @SerializedName("idcliente")
    var idcliente: String? = null,
    @SerializedName("nombres_apellidos")
    var nombresApellidos: String? = null,
    @SerializedName("telefono_casa")
    var telefonoCasa: String? = null
): Serializable