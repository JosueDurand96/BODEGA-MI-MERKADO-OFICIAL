package com.mimerkado.networking.interactor.rx.formurlencoded

import com.mimerkado.networking.NetworkingManager
import com.mimerkado.networking.interactor.rx.RxPayload
import com.mimerkado.networking.model.NetworkingConfiguration
import com.mimerkado.networking.util.NetworkingHttpVerb
import com.mimerkado.networking.util.BodyUtil
import io.reactivex.Single
import okhttp3.HttpUrl
import retrofit2.Response

/**
 * Class with implements BCPRxPayload and return a response or error
 */
class RxFormUrlEncodedPayload : RxPayload {

    @Throws(Throwable::class)
    override fun payload(bcpNetworkingConfiguration: NetworkingConfiguration): Single<Response<Any>> {

        val response = NetworkingManager
            .connect(RxFormUrlEncodedService::class.java, bcpNetworkingConfiguration)

        return when (bcpNetworkingConfiguration.httpVerb) {
            NetworkingHttpVerb.GET -> response.get(
                url(
                    bcpNetworkingConfiguration.baseUrl,
                    bcpNetworkingConfiguration.endpoint
                )
            )
            NetworkingHttpVerb.DELETE -> response.delete(
                url(
                    bcpNetworkingConfiguration.baseUrl,
                    bcpNetworkingConfiguration.endpoint
                )
            )
            NetworkingHttpVerb.PATCH -> response.patch(
                url(
                    bcpNetworkingConfiguration.baseUrl,
                    bcpNetworkingConfiguration.endpoint
                ),
                BodyUtil.getBodyFormUrlEncoded(bcpNetworkingConfiguration)
            )
            NetworkingHttpVerb.PUT -> response.put(
                url(
                    bcpNetworkingConfiguration.baseUrl,
                    bcpNetworkingConfiguration.endpoint
                ),
                BodyUtil.getBodyFormUrlEncoded(bcpNetworkingConfiguration)
            )
            else -> response.post(
                url(
                    bcpNetworkingConfiguration.baseUrl,
                    bcpNetworkingConfiguration.endpoint
                ),
                BodyUtil.getBodyFormUrlEncoded(bcpNetworkingConfiguration)
            )
        }
    }

    override fun showError(): String = "For FormUrlEncoded BodyType, payload HashMap is required"

    override fun url(baseUrl: String?, endpoint: String?) = HttpUrl.parse(baseUrl.plus(endpoint)).toString()
}