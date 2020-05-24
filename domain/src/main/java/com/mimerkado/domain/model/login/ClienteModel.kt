package com.mimerkado.domain.model.login

data class ClienteModel(
    var celular: String? = null,
    var correo: String? = null,
    var dni: String? = null,
    var domicilio: String? = null,
    var estado: String? = null,
    var fecha_nacimiento: String? = null,
    var idcliente: String? = null,
    var nombres_apellidos: String? = null,
    var telefono_casa: String? = null
)