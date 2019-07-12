package com.example.wushi.mykotlin_developers.ext

import android.content.Context
import android.support.v4.app.Fragment
import com.example.wushi.mykotlin_developers.widget.CustomToast

/**
 * @author wsw
 *
 */


fun Context.showToast(content: String) {
    CustomToast(this, content).show()
}

fun Fragment.showToast(content: String) {
    CustomToast(this.activity?.applicationContext, content).show()
}