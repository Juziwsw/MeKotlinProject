package com.example.wushi.mykotlin_developers.app

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.support.multidex.MultiDexApplication
import android.support.v7.app.AppCompatDelegate
import com.cxz.multiplestatusview.BuildConfig
import com.example.wushi.mykotlin_developers.constant.Constant
import com.example.wushi.mykotlin_developers.utils.CommonUtil
import com.example.wushi.mykotlin_developers.utils.DisplayManager
import com.example.wushi.mykotlin_developers.utils.SettingUtil
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import org.litepal.LitePal
import java.util.*
import kotlin.properties.Delegates
import com.tencent.bugly.crashreport.CrashReport
import com.tencent.bugly.crashreport.CrashReport.UserStrategy


/**
 * @author wsw
 *
 */
class App : MultiDexApplication() {
    private var refWatcher: RefWatcher? = null

    companion object {
        private val TAG = "App"
        var context: Context by Delegates.notNull()
            private set
        lateinit var instance: Application

        fun getRefWatcher(context: Context): RefWatcher? {
            var app = context.applicationContext as App
            return app.refWatcher
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        context = applicationContext
        refWatcher = setRefWatcher()
        initConfig()
        DisplayManager.init(this)
        registerActivityLifecycleCallbacks(mRegisterActivityLifecycleCallbacks)
        initTheme()
        initLitePal()
        initBugly()


    }

    /**
     * 初始化数据库
     */
    private fun initLitePal() {
        LitePal.initialize(this)
    }

    /**
     * 初始化bugly
     */
    private fun initBugly() {
        if (BuildConfig.DEBUG) {
            return
        }
        // 获取当前包名
        val packageName = applicationContext.packageName
        // 获取当前进程名
        val processName = CommonUtil.getProcessName(android.os.Process.myPid())

        // 设置是否为上报进程
        val strategy = UserStrategy(applicationContext)
        strategy.isUploadProcess = processName == null || processName == packageName
        // 初始化Bugly
        CrashReport.initCrashReport(context, Constant.BUGLY_ID, BuildConfig.DEBUG, strategy)
        // 如果通过“AndroidManifest.xml”来配置APP信息，初始化方法如下
        // CrashReport.initCrashReport(context, strategy);

    }

    fun initTheme() {
        if (SettingUtil.getIsAutoNightMode()) {
            val nightStartHour = SettingUtil.getNightStartHour().toInt()
            val nightStartMinute = SettingUtil.getNightStartMinute().toInt()
            val dayStartHour = SettingUtil.getDayStartHour().toInt()
            val dayStartMinute = SettingUtil.getDayStartMinute().toInt()

            val calendar = Calendar.getInstance()
            val currentHour = calendar.get(Calendar.HOUR_OF_DAY)
            val currentMinute = calendar.get(Calendar.MINUTE)

            val nightValue = nightStartHour * 60 + nightStartMinute
            val dayValue = dayStartHour * 60 + dayStartMinute
            val currentValue = currentHour * 60 + currentMinute

            if (currentValue >= nightValue || currentValue <= dayValue) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                SettingUtil.setIsNightMode(true)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                SettingUtil.setIsNightMode(false)
            }
        } else {
            // 获取当前的主题
            if (SettingUtil.getIsNightMode()) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

    fun setRefWatcher(): RefWatcher {
        return if (LeakCanary.isInAnalyzerProcess(context)) {
            RefWatcher.DISABLED
        } else {
            LeakCanary.install(this)
        }
    }

    fun initConfig() {
        val formatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false)  // 隐藏线程信息 默认：显示
            .methodCount(0)         // 决定打印多少行（每一行代表一个方法）默认：2
            .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
            .tag("wsw")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
            .build()
        Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })

    }

    private val mRegisterActivityLifecycleCallbacks = object : Application.ActivityLifecycleCallbacks {
        override fun onActivityPaused(activity: Activity?) {
            Logger.d("onActivityPaused$activity?.componentName?.className")
        }

        override fun onActivityResumed(activity: Activity?) {
            Logger.d("onActivityResumed" + activity?.componentName?.className)
        }

        override fun onActivityStarted(activity: Activity?) {
        }

        override fun onActivityDestroyed(activity: Activity?) {
        }

        override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
        }

        override fun onActivityStopped(activity: Activity?) {
        }

        override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
        }

    }

}