package com.mimerkado.data.mapper.login

import com.mimerkado.data.entities.login.LoginEntity
import com.mimerkado.data.mapper.Mapper
import com.mimerkado.domain.model.login.LoginModel

class LoginMapper: Mapper<LoginModel, LoginEntity>() {

    private val clientMapper = ClienteMapper()

    override fun mapToEntity(type: LoginEntity): LoginModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun mapToEntity(type: List<LoginEntity>): List<LoginModel> {
        val itemList:MutableList<LoginModel> = mutableListOf()
        type.forEach {
            val usuarioModel = LoginModel(clientMapper.mapToEntity(it.cliente!!))
            itemList.add(usuarioModel)
        }
        return itemList
    }

}