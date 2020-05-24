package com.mimerkado.bodega.screen

import com.mimerkado.domain.model.login.ClienteModel

sealed class LoginState {
    class ShowSuccess(val list :List<ClienteModel>) : LoginState()
    object ShowError : LoginState()
}