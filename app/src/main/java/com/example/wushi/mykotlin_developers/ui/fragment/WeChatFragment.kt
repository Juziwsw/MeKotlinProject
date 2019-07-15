package com.example.wushi.mykotlin_developers.ui.fragment

import android.view.View
import com.example.wushi.mykotlin_developers.R
import com.example.wushi.mykotlin_developers.base.BaseMvpFragment
import com.example.wushi.mykotlin_developers.mvp.contract.WeChatContract
import com.example.wushi.mykotlin_developers.mvp.model.bean.WXChapterBean
import com.example.wushi.mykotlin_developers.mvp.presenter.WeChatPresenter
import kotlinx.android.synthetic.main.fragment_wechat.*

/**
 * @author wsw
 *
 */
class WeChatFragment : BaseMvpFragment<WeChatContract.View, WeChatContract.Presenter>(), WeChatContract.View {
    companion object {
        fun getInstance() = WeChatFragment()
    }
    private

    override fun createPresenter(): WeChatContract.Presenter = WeChatPresenter()

    override fun attachLayoutRes(): Int = R.layout.fragment_wechat
    override fun initView(view: View) {
        super.initView(view)
        mLayoutStatusView = multiple_status_view

    }

    override fun lazyLoad() {

    }

    override fun scrollToTop() {
    }

    override fun showWXChapters(chapters: MutableList<WXChapterBean>) {
    }
}