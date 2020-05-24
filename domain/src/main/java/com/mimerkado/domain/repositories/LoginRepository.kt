package com.mimerkado.domain.repositories

import com.mimerkado.domain.model.login.ClienteModel
import com.mimerkado.helper.base.ResultType
import com.mimerkado.helper.error.Failure

interface LoginRepository {

    suspend fun getUser(phone:String,key:String): ResultType<Failure, List<ClienteModel>>
}