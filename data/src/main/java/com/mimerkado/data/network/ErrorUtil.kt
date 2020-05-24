package com.mimerkado.data.network

import com.mimerkado.helper.error.Failure
import java.net.ConnectException

object ErrorUtil {

    fun handler(t: Throwable?): Failure {
        return when(t){
            is ConnectException -> Failure.NetworkConnection
            else -> Failure.DefaultError
        }
    }

}