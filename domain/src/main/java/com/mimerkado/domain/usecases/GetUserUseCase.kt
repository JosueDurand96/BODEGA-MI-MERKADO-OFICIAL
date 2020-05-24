package com.mimerkado.domain.usecases

import com.mimerkado.domain.model.login.ClienteModel
import com.mimerkado.domain.repositories.LoginRepository
import com.mimerkado.helper.base.ResultType
import com.mimerkado.helper.base.UseCase
import com.mimerkado.helper.error.Failure

class GetUserUseCase(private val loginRepository: LoginRepository):
    UseCase<List<ClienteModel>, GetUserUseCase.Params>() {

    data class Params(val phone: String, val key: String)

    override suspend fun run(params: Params): ResultType<Failure, List<ClienteModel>> {
        return loginRepository.getUser(params.phone,params.key)
    }
}