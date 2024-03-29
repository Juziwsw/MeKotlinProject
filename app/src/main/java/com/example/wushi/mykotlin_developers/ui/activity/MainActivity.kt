package com.example.wushi.mykotlin_developers.ui.activity


import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.example.wushi.mykotlin_developers.R
import com.example.wushi.mykotlin_developers.base.BaseMvpActivity
import com.example.wushi.mykotlin_developers.mvp.contract.MainContract
import com.example.wushi.mykotlin_developers.mvp.presenter.MainPresenter
import com.example.wushi.mykotlin_developers.ui.fragment.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseMvpActivity<MainContract.MainView, MainContract.MainPresenter>(), MainContract.MainView {

    private val BOTTOM_INDEX: String = "bottom_index"

    private val FRAGMENT_HOME = 0x01
    private val FRAGMENT_KNOWLEDGE = 0x02
    private val FRAGMENT_NAVIGATION = 0x03
    private val FRAGMENT_PROJECT = 0x04
    private val FRAGMENT_WECHAT = 0x05

    private var mHomeFragment: HomeFragment? = null
    private var mKnowledgeTreeFragment: KnowledgeTreeFragment? = null
    private var mNavigationFragment: NavigationFragment? = null
    private var mProjectFragment: ProjectFragment? = null
    private var mWeChatFragment: WeChatFragment? = null

    private var mIndex = FRAGMENT_HOME
    override fun start() {
    }

    override fun createPresenter(): MainContract.MainPresenter = MainPresenter()

    override fun showLogoutSuccess(success: Boolean) {
    }


    override fun attachLayoutRes(): Int = R.layout.activity_main
    override fun initData() {
    }

    override fun initView() {
        super.initView()
        toolbar.run {
            title = resources.getString(R.string.app_name)
            setSupportActionBar(this)
        }
        bottom_navigation.run {
            // 以前使用 BottomNavigationViewHelper.disableShiftMode(this) 方法来设置底部图标和字体都显示并去掉点击动画
            // 升级到 28.0.0 之后，官方重构了 BottomNavigationView ，目前可以使用 labelVisibilityMode = 1 来替代
            // BottomNavigationViewHelper.disableShiftMode(this)
            labelVisibilityMode = 1
            setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        }
        showFragment(FRAGMENT_HOME)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt(BOTTOM_INDEX, mIndex)
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
        return@OnNavigationItemSelectedListener when (menuItem.itemId) {
            R.id.action_home -> {
                showFragment(FRAGMENT_HOME)
                true
            }
            R.id.action_knowledge_system -> {
                showFragment(FRAGMENT_KNOWLEDGE)
                true
            }
            R.id.action_wechat -> {
                showFragment(FRAGMENT_WECHAT)
                true
            }
            R.id.action_navigation -> {
                showFragment(FRAGMENT_NAVIGATION)
                true
            }
            R.id.action_project -> {
                showFragment(FRAGMENT_PROJECT)
                true
            }
            else -> false
        }
    }

    /**
     * 展示Fragment
     * @param index
     */
    private fun showFragment(index: Int) {
        var transition = supportFragmentManager.beginTransaction()
        hintFragment(transition)
        mIndex = index
        when (index) {
            //首页
            FRAGMENT_HOME -> {
                toolbar.title = getString(R.string.app_name)
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.getInstance(FRAGMENT_HOME)
                    transition.add(R.id.container, mHomeFragment!!, "home")
                } else {
                    transition.show(mHomeFragment as Fragment)
                }
            }
            //知识体系
            FRAGMENT_KNOWLEDGE -> {
                toolbar.title = getString(R.string.knowledge_system)
                if (mKnowledgeTreeFragment == null) {
                    mKnowledgeTreeFragment = KnowledgeTreeFragment.getInstance()
                    transition.add(R.id.container, mKnowledgeTreeFragment!!, "knowledgeTree")
                } else {
                    transition.show(mKnowledgeTreeFragment as Fragment)
                }

            }
            //公共号
            FRAGMENT_WECHAT -> {
                toolbar.title = getString(R.string.wechat)
                if (mWeChatFragment == null) {
                    mWeChatFragment = WeChatFragment.getInstance()
                    transition.add(R.id.container, mWeChatFragment!!, "WeChat")
                } else {
                    transition.show(mWeChatFragment as Fragment)
                }
            }
            //项目
            FRAGMENT_PROJECT -> {
                toolbar.title = getString(R.string.project)
                if (mProjectFragment == null) {
                    mProjectFragment = ProjectFragment.getInstance()
                    transition.add(R.id.container, mProjectFragment!!, "project")
                } else {
                    transition.show(mProjectFragment as Fragment)
                }
            }
            //导航
            FRAGMENT_NAVIGATION ->{
                toolbar.title = getString(R.string.navigation)
                if (mNavigationFragment == null) {
                    mNavigationFragment = NavigationFragment.getInstance()
                    transition.add(R.id.container, mNavigationFragment!!, "Navigation")
                } else {
                    transition.show(mNavigationFragment as Fragment)
                }
            }

        }
        transition.commit()

    }

    /**
     * 隐藏全部的Fragment
     */
    private fun hintFragment(fragmentTransaction: FragmentTransaction) {
        mHomeFragment?.let { fragmentTransaction.hide(it) }
        mKnowledgeTreeFragment?.let { fragmentTransaction.hide(it) }
        mNavigationFragment?.let { fragmentTransaction.hide(it) }
        mProjectFragment?.let { fragmentTransaction.hide(it) }
        mWeChatFragment?.let { fragmentTransaction.hide(it) }
    }

}

