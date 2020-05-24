package com.mimerkado.bodega.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bcp.core.storage.BCPStorage
import com.bcp.core.storage.StorageLevel
import com.mimerkado.data.implements.LoginRepositoryImpl
import com.mimerkado.domain.usecases.GetUserUseCase
import com.mimerkado.helper.util.ViewModelUtil
import com.mimerkado.bodega.MainPrincipalActivity
import com.mimerkado.bodega.R
import com.mimerkado.bodega.ScreenState
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private var coreStorage: BCPStorage? = null
    private lateinit var btnLogin: Button
    private lateinit var btnRegister: Button
    private lateinit var txtPhone: EditText
    private lateinit var txtPassword: EditText
    private var idcliente: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        txtPhone = findViewById(R.id.txtCelular)
        txtPassword = findViewById(R.id.txtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnRegister = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener {

          // val intent = Intent(applicationContext, RegisterActivity::class.java)
          //  startActivity(intent)
        }



        btnLogin.setOnClickListener {
            if (!validate()) {
                Toast.makeText(applicationContext, "Debe ingresar datos", Toast.LENGTH_SHORT).show()

            } else {
                loginViewModel.getUser(txtPhone.text.toString(), txtPassword.text.toString())
            }
        }

        loginViewModel.state.observe(::getLifecycle, ::updateUI)

        coreStorage = BCPStorage.newInstance()
        idcliente = coreStorage?.getString("idcliente", StorageLevel.NON_SENSITIVE_PERSIST)

        if (idcliente == null) {
            Log.d("josue", "id cliente 1" + idcliente)
        } else if (idcliente!!.isEmpty()) {
            Log.d("josue", "id cliente 2" + idcliente)
        } else {
            Log.d("josue","id cliente 3"+ idcliente)
            val intent = Intent(this, MainPrincipalActivity::class.java)
            startActivity(intent)
        }


    }

    private fun validate(): Boolean {
        var valid = true
        if (txtPhone.text.toString().isEmpty() || txtPhone.length() > 32) {
            txtPhone.error = "Ingrese su celular"
            valid = false
        }
        if (txtPassword.text.toString().isEmpty() || txtPassword.length() > 4) {
            txtPassword.error = "Ingrese su password"
            valid = false
        }
        return valid
    }

    private val loginViewModel by lazy {
        ViewModelProvider(this@LoginActivity, ViewModelUtil.viewModelFactory { createViewModel() })
            .get(LoginViewModel::class.java)
    }

    private fun createViewModel(): LoginViewModel {

        val loginRepository = LoginRepositoryImpl(this)
        val loginUserCase =
            GetUserUseCase(
                loginRepository
            )

        return LoginViewModel(
            loginUserCase
        )
    }


    private fun updateUI(screenState: ScreenState<LoginState>) {

        when (screenState) {

            ScreenState.Loading -> {
                pbLoad.visibility = View.VISIBLE
            }
            is ScreenState.Render -> processRenderState(screenState.renderState)
        }
    }

    private fun processRenderState(renderState: LoginState) {

        pbLoad.visibility = View.GONE

        when (renderState) {

            is LoginState.ShowSuccess -> {
                Toast.makeText(applicationContext, "Bienvenido", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainPrincipalActivity::class.java)
                startActivity(intent)
            }
            is LoginState.ShowError -> {
                Toast.makeText(applicationContext, "No se encontró al Usuario", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onBackPressed() {
        println()
    }
}
