package com.mimerkado.bodega.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mimerkado.domain.model.login.ClienteModel
import com.mimerkado.domain.usecases.GetUserUseCase
import com.mimerkado.helper.error.Failure
import kotlinx.coroutines.launch

import com.bcp.core.storage.BCPStorage
import com.bcp.core.storage.StorageLevel
import com.mimerkado.bodega.ScreenState


class LoginViewModel(private val getUserUseCase: GetUserUseCase) : ViewModel() {
    private var coreStorage: BCPStorage? = null
    private var _state: MutableLiveData<ScreenState<LoginState>> = MutableLiveData()

    val state: LiveData<ScreenState<LoginState>>
        get() = _state


    fun getUser(phone: String, key: String) {
        _state.value = ScreenState.Loading
        viewModelScope.launch {
            getUserUseCase.run(GetUserUseCase.Params(phone, key)).either(::error, ::responseLogin)
        }
    }

    private var idcliente: String = ""


     fun responseLogin(user: List<ClienteModel>) {
        _state.value = ScreenState.Render(LoginState.ShowSuccess(user))

         idcliente =user[0].idcliente.toString()

         coreStorage = BCPStorage.newInstance()
         coreStorage?.set("idcliente", idcliente, StorageLevel.NON_SENSITIVE_PERSIST)

    }


    private fun error(failure: Failure) {
        when (failure) {
            is Failure.ServerError, Failure.DefaultError -> {
                _state.value =
                    ScreenState.Render(LoginState.ShowError)
            }

        }
    }
}