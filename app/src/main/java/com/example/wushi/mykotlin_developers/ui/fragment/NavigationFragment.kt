package com.example.wushi.mykotlin_developers.ui.fragment

import android.view.View
import com.example.wushi.mykotlin_developers.R
import com.example.wushi.mykotlin_developers.base.BaseFragment

/**
 * @author wsw
 *导航
 */
class NavigationFragment : BaseFragment() {
    companion object {
        fun getInstance(): NavigationFragment = NavigationFragment()
    }

    override fun attachLayoutRes(): Int = R.layout.fragment_navigation

    override fun initView(view: View) {
    }

    override fun lazyLoad() {
    }
}