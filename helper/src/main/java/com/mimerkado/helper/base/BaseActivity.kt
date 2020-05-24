package com.mimerkado.helper.base

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.mimerkado.helper.themes.ThemeManager
import com.mimerkado.helper.util.CertificateUtil
import com.mimerkado.helper.BuildConfig
import com.mimerkado.networking.NetworkingManager
import com.mimerkado.networking.model.Networking
import com.mimerkado.networking.model.NetworkingBaseConfiguration
import com.mimerkado.networking.util.NetworkingType
import com.mimerkado.networking.util.InputStreamUtil


abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ThemeManager.setTheme(this)
        initNetworkingConfiguration()
    }

    open fun showProgress() {
        window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }

    open fun hideProgress() {
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }

    private fun initNetworkingConfiguration() {

        val networkingConfiguration = NetworkingBaseConfiguration.BCPNetworkingBaseConfigurationBuilder()
            .baseUrl(BuildConfig.BASE_URL)
            .timeout(1)
            .mutual(false)
            .type(NetworkingType.COROUTINES)
            .build()

        val bcpNetworking = Networking.BCPNetworkingBuilder()
            .bcpNetworkingBaseConfiguration(networkingConfiguration)
            .pwd("h1l2s4p5e7A8B7P4E5V".toCharArray())
            .certificate(InputStreamUtil.inputStreamToString(CertificateUtil.certificate(this)))
            .build()

        NetworkingManager.init(bcpNetworking)

    }

}