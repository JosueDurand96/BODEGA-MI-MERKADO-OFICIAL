package com.mimerkado.networking.interactor.coroutine

import com.mimerkado.networking.service.ResultService
import com.mimerkado.networking.model.NetworkingConfiguration
import com.mimerkado.networking.util.NetworkingHttpVerb

/**
 * Middle class between BCPNetworkingManager and BCPNetworkingCoroutineInteractor
 *
 * @param bcpNetworkingConfiguration module configuration
 */
class NetworkingCoroutineBuilder(
    private val bcpNetworkingConfiguration: NetworkingConfiguration
) {

    /**
     * Depending to the httpVerb (BCPNetworkingConfiguration), notify BCPNetworkingCoroutineInteractor
     */
    suspend fun connect(): ResultService {

        return when (bcpNetworkingConfiguration.httpVerb) {
            NetworkingHttpVerb.GET -> NetworkingCoroutineInteractor.GET.execute(bcpNetworkingConfiguration)
            NetworkingHttpVerb.POST -> NetworkingCoroutineInteractor.POST.execute(bcpNetworkingConfiguration)
            NetworkingHttpVerb.PUT -> NetworkingCoroutineInteractor.PUT.execute(bcpNetworkingConfiguration)
            NetworkingHttpVerb.PATCH -> NetworkingCoroutineInteractor.PATCH.execute(bcpNetworkingConfiguration)
            NetworkingHttpVerb.DELETE -> NetworkingCoroutineInteractor.DELETE.execute(bcpNetworkingConfiguration)
            else -> NetworkingCoroutineInteractor.GET.execute(bcpNetworkingConfiguration)
        }
    }
}