package com.mimerkado.data.mapper.login

import com.mimerkado.data.entities.login.ClienteEntity
import com.mimerkado.data.mapper.Mapper
import com.mimerkado.domain.model.login.ClienteModel

class ClienteMapper: Mapper<ClienteModel, ClienteEntity>() {

    override fun mapToEntity(type: ClienteEntity): ClienteModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun mapToEntity(type: List<ClienteEntity>): List<ClienteModel> {
        val itemList:MutableList<ClienteModel> = mutableListOf()
        type.forEach {
            val datoModel = ClienteModel(it.celular,it.correo,it.dni,it.domicilio,it.estado,it.fechaNacimiento,it.idcliente,it.nombresApellidos,it.telefonoCasa)
            itemList.add(datoModel)
        }
        return  itemList
    }
}