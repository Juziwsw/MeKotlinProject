package com.example.wushi.mykotlin_developers.utils

import android.text.TextUtils
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

/**
 * @author wsw
 *
 */
object CommonUtil {
    fun getProcessName(pid: Int): String{
        var reader: BufferedReader? = null
        try {
            reader = BufferedReader(FileReader("/proc/$pid/cmdline"))
            var processName = reader!!.readLine()
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim({ it <= ' ' })
            }
            return processName
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
        } finally {
            try {
                if (reader != null) {
                    reader!!.close()
                }
            } catch (exception: IOException) {
                exception.printStackTrace()
            }
        }
        return ""
    }
}