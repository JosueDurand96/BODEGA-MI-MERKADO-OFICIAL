package com.mimerkado.data.implements

import android.content.Context
import com.mimerkado.data.entities.login.LoginEntity
import com.mimerkado.data.entities.register.RegisterEntity
import com.mimerkado.data.mapper.login.ClienteMapper
import com.mimerkado.data.mapper.register.RegisterMapper
import com.mimerkado.data.network.ErrorUtil
import com.mimerkado.data.network.Network
import com.mimerkado.domain.model.login.ClienteModel
import com.mimerkado.domain.repositories.LoginRepository
import com.mimerkado.helper.base.ResultType
import com.mimerkado.helper.error.Failure
import com.mimerkado.networking.NetworkingManager
import com.mimerkado.networking.model.NetworkingConfiguration
import com.mimerkado.networking.service.ResultService
import com.mimerkado.networking.util.NetworkingHttpVerb
import com.google.gson.Gson

class LoginRepositoryImpl(val context: Context): LoginRepository {

    private val gson = Gson()

    override suspend fun getUser(
        phone: String,
        key: String
    ): ResultType<Failure, List<ClienteModel>> {

        val query = "Clientes/login/$phone/$key"
        val networkConfiguration = NetworkingConfiguration.CPNetworkingConfigurationBuilder()
            .endpoint(query)
            .header(Network.getGenericHeader(context))
            .httpVerb(NetworkingHttpVerb.GET)
            .config()

        return try {
            val result: ResultService = NetworkingManager.with(networkConfiguration).connect()

            return if(result.isSuccessful){
                val datoEntity: LoginEntity = gson.fromJson(gson.toJson(result.body), LoginEntity::class.java)
                ResultType.Success(ClienteMapper().mapToEntity(datoEntity.cliente!!))
            }else{
                val error: RegisterEntity = gson.fromJson(gson.toJson(result.error), RegisterEntity::class.java)
                ResultType.Failure(Failure.ServerError(RegisterMapper().mapToEntity(error)))
            }
        }catch (e : Exception){
            ResultType.Failure(ErrorUtil.handler(e))
        }
    }
}