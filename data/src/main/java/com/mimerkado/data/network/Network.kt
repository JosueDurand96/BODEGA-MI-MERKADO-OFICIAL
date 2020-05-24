package com.mimerkado.data.network

import android.content.Context
import android.util.Log

object Network {

    fun getGenericHeader(context: Context): HashMap<String, String>{

        val genericHeader = HashMap<String, String>()
        genericHeader["access_token"] = "7ff63604-9e61-4c5b-ad69-48c06fab041e"
        Log.d("genericHeader",genericHeader.toString())

        return genericHeader

    }

    fun getGenericHeader(): HashMap<String, String>{

        val genericHeader = HashMap<String, String>()
        genericHeader["access_token"] = "7ff63604-9e61-4c5b-ad69-48c06fab041e"
        Log.d("genericHeader",genericHeader.toString())

        return genericHeader

    }

}