package com.mimerkado.bodega.customizable

import android.os.SystemClock
import android.view.View

class DisableClickListener(private var defaultInterval: Int = 2000, private val onSafeCLick: (View) -> Unit) : View.OnClickListener {

    private var lastTimeClicked: Long = 0

    override fun onClick(v: View) {

        if (SystemClock.elapsedRealtime() - lastTimeClicked < defaultInterval) {
            return
        }

        lastTimeClicked = SystemClock.elapsedRealtime()

        onSafeCLick(v)
    }
}

fun View.setOnClickDisableListener(onSafeClick: (View) -> Unit) {

    val safeClickListener = DisableClickListener {
        onSafeClick(it)
    }

    setOnClickListener(safeClickListener)
}