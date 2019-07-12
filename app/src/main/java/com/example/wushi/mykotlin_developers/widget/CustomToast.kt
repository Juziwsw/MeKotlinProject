package com.example.wushi.mykotlin_developers.widget

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.wushi.mykotlin_developers.R
import kotlinx.android.synthetic.main.toast_custom.view.*

/**
 * @author wsw
 *
 */
class CustomToast {
    private var toast: Toast

    constructor(context: Context?, message: String) : this(context, message, Toast.LENGTH_SHORT)

    constructor(context: Context?, msg: String, duration: Int) {
        toast = Toast(context)
        val toastView: View = LayoutInflater.from(context).inflate(R.layout.toast_custom, null)
        toast.view = toastView
        var txtContent: TextView = toastView.txt_toast
        txtContent.text = msg
        toast.duration = duration
        toast.setGravity(Gravity.CENTER, 0, 0)

    }

    fun show() {
        toast?.show()
    }
}