package com.example.wushi.mykotlin_developers.base

import android.content.Context
import android.graphics.PixelFormat
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.cxz.multiplestatusview.MultipleStatusView
import com.example.wushi.mykotlin_developers.R
import com.example.wushi.mykotlin_developers.constant.Constant
import com.example.wushi.mykotlin_developers.event.NetworkChangeEvent
import com.example.wushi.mykotlin_developers.receiver.NetworkChangeReceiver
import com.example.wushi.mykotlin_developers.utils.Preference
import com.example.wushi.mykotlin_developers.utils.SettingUtil
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * @author wsw
 *
 */
abstract class BaseActivity : AppCompatActivity() {
    /**
     * check login
     */
    protected var isLogin: Boolean by Preference(Constant.LOGIN_KEY, false)

    /**
     * 缓存上一次的网络状态
     */
    protected var hasNetwork: Boolean by Preference(Constant.HAS_NETWORK_KEY, true)

    /**
     * 网络状态变化的广播
     */
    protected var mNetworkChangeReceiver: NetworkChangeReceiver? = null

    /**
     * theme color
     */
    protected var mThemeColor: Int = SettingUtil.getColor()

    /**
     * 多种状态的 View 的切换
     */
    protected var mLayoutStatusView: MultipleStatusView? = null

    /**
     * 提示View
     */
    protected lateinit var mTipView: View
    protected lateinit var mWindowManager: WindowManager
    protected lateinit var mLayoutParams: WindowManager.LayoutParams


    /**
     * 布局文件id
     */
    protected abstract fun attachLayoutRes(): Int

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 初始化 View
     */
    abstract fun initView()

    /**
     * 开始请求
     */
    abstract fun start()

    /**
     * 是否使用 EventBus
     */
    open fun useEventBus(): Boolean = true

    /**
     * 是否需要显示 TipView
     */
    open fun enableNetworkTip(): Boolean = true

    /**
     * 无网状态—>有网状态 的自动重连操作，子类可重写该方法
     */
    open fun doReConnected() {
        start()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        super.onCreate(savedInstanceState)
        setContentView(attachLayoutRes())
        if (useEventBus()) {
            EventBus.getDefault().register(this)
        }
        initView()
        initData()
        initTipView()
        start()
        initListener()

    }
    /**
     * Network Change
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onNetworkChangeEvent(event: NetworkChangeEvent) {
        hasNetwork = event.isConnected
        checkNetwork(event.isConnected)
    }

    private fun checkNetwork(isConnected: Boolean) {
        if (enableNetworkTip()) {
            if (isConnected) {
                doReConnected()
                if (mTipView != null && mTipView.parent != null) {
                    mWindowManager.removeView(mTipView)
                }
            } else {
                if (mTipView.parent == null) {
                    mWindowManager.addView(mTipView, mLayoutParams)
                }
            }
        }
    }



    /**
     * 初始化mTipView
     */
    private fun initTipView() {
        mTipView = layoutInflater.inflate(R.layout.layout_network_tip, null)
        mWindowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        mLayoutParams = WindowManager.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.TYPE_APPLICATION,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            PixelFormat.TRANSLUCENT
        )
        mLayoutParams.gravity = Gravity.TOP
        mLayoutParams.x = 0
        mLayoutParams.y = 0
        mLayoutParams.windowAnimations = R.style.anim_float_view // add animations
    }

    /**
     * 空界面,错误界面点击添加事件
     */
    private fun initListener() {
        mLayoutStatusView?.setOnClickListener(mRetryClickListener)
    }

    /**
     * open 修饰的,可以被重写
     */
    open val mRetryClickListener: View.OnClickListener = View.OnClickListener {
        start()
    }

}