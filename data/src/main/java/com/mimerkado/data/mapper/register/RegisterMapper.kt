package com.mimerkado.data.mapper.register

import com.mimerkado.data.entities.register.RegisterEntity
import com.mimerkado.data.mapper.Mapper
import com.mimerkado.domain.model.register.RegisterModel

class RegisterMapper: Mapper<RegisterModel, RegisterEntity>() {

    override fun mapToEntity(type: RegisterEntity): RegisterModel {
        return RegisterModel(type.error,type.mensaje)
    }
}