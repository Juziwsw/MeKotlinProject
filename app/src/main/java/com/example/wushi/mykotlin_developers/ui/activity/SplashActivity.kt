package com.example.wushi.mykotlin_developers.ui.activity

import android.content.Intent
import com.example.wushi.mykotlin_developers.R
import com.example.wushi.mykotlin_developers.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * @author wsw
 *
 */
class SplashActivity : BaseActivity() {
    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

    }*/
    override fun attachLayoutRes(): Int = R.layout.activity_splash

    override fun initData() {
    }

    override fun enableNetworkTip(): Boolean = false
    override fun useEventBus(): Boolean = false

    override fun initView() {
        textView.text = "设置第一次内容"
        imageView.postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 1000)
        textView.text = "设置第二次内容"
    }

    override fun start() {
    }

}