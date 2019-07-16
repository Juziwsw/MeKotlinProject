package com.example.wushi.mykotlin_developers.ui.fragment

import android.view.View
import com.example.wushi.mykotlin_developers.R
import com.example.wushi.mykotlin_developers.base.BaseFragment

/**
 * @author wsw
 * 项目
 */
class ProjectFragment : BaseFragment() {
    companion object {
        fun getInstance() = ProjectFragment()
    }

    override fun attachLayoutRes(): Int = R.layout.fragment_project

    override fun initView(view: View) {
    }

    override fun lazyLoad() {
    }

}