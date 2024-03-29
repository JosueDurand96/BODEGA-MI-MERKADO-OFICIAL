package com.mimerkado.networking.interactor.rx

import com.mimerkado.networking.model.NetworkingConfiguration
import com.mimerkado.networking.interactor.rx.formurlencoded.RxFormUrlEncodedPayload
import com.mimerkado.networking.interactor.rx.json.RxJsonPayload
import com.mimerkado.networking.util.NetworkingBody
import io.reactivex.Single
import retrofit2.Response

/**
 * Class that makes calls to the server
 */
enum class NetworkingRxInteractor {

    /* get http verb */
    GET {
        @Throws(Throwable::class)
        override fun execute(
            bcpNetworkingConfiguration: NetworkingConfiguration
        ): Single<Response<Any>> {
            return NetworkingRxService.execute(
                payloadRxType(bcpNetworkingConfiguration.bodyType!!).payload(
                    bcpNetworkingConfiguration
                )
            )
        }
    },

    /* post http verb */
    POST {

        @Throws(Throwable::class)
        override fun execute(
            bcpNetworkingConfiguration: NetworkingConfiguration
        ): Single<Response<Any>> {
            return NetworkingRxService.execute(
                payloadRxType(bcpNetworkingConfiguration.bodyType!!).payload(
                    bcpNetworkingConfiguration
                )
            )
        }
    },

    /* put http verb */
    PUT {

        @Throws(Throwable::class)
        override fun execute(
            bcpNetworkingConfiguration: NetworkingConfiguration
        ): Single<Response<Any>> {
            return NetworkingRxService.execute(
                payloadRxType(bcpNetworkingConfiguration.bodyType!!).payload(
                    bcpNetworkingConfiguration
                )
            )
        }
    },

    /* patch http verb */
    PATCH {
        @Throws(Throwable::class)
        override fun execute(
            bcpNetworkingConfiguration: NetworkingConfiguration
        ): Single<Response<Any>> {
            return NetworkingRxService.execute(
                payloadRxType(bcpNetworkingConfiguration.bodyType!!).payload(
                    bcpNetworkingConfiguration
                )
            )
        }
    },

    /* delete http verb */
    DELETE {

        @Throws(Throwable::class)
        override fun execute(
            bcpNetworkingConfiguration: NetworkingConfiguration
        ): Single<Response<Any>> {
            return NetworkingRxService.execute(
                payloadRxType(bcpNetworkingConfiguration.bodyType!!).payload(
                    bcpNetworkingConfiguration
                )
            )
        }
    };

    /**
     *  Execute the call to the server
     *
     *  @param bcpNetworkingConfiguration module configuration
     */
    @Throws(Throwable::class)
    internal abstract fun execute(
        bcpNetworkingConfiguration: NetworkingConfiguration
    ): Single<Response<Any>>

    /**
     *  Validate bodyType
     *
     *  @param bcpNetworkingConfiguration module configuration
     *  @return BCPCoroutinePayload with Factory pattern
     */
    @Throws(Throwable::class)
    protected fun payloadRxType(bodyType: NetworkingBody): RxPayload {
        return when (bodyType) {
            NetworkingBody.JSON -> RxJsonPayload()
            NetworkingBody.FORMURLENCODED -> RxFormUrlEncodedPayload()
        }
    }
}