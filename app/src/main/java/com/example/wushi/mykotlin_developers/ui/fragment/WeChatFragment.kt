package com.example.wushi.mykotlin_developers.ui.fragment

import android.view.View
import com.example.wushi.mykotlin_developers.R
import com.example.wushi.mykotlin_developers.adapter.WeChatPagerAdapter
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

    /**
     * datas
     */
    private val datas = mutableListOf<WXChapterBean>()
    private val weChatPagerAdapter: WeChatPagerAdapter by lazy {
        WeChatPagerAdapter(datas, childFragmentManager)
    }

    override fun createPresenter(): WeChatContract.Presenter = WeChatPresenter()

    override fun attachLayoutRes(): Int = R.layout.fragment_wechat
    override fun initView(view: View) {
        super.initView(view)
        mLayoutStatusView = multiple_status_view
        tabLayout.run {
            //这一步才会viewpage和tablayout链接起来
            setupWithViewPager(viewPager)
        }

    }

    override fun showLoading() {
        mLayoutStatusView?.showLoading()
    }

    override fun showError(errorMsg: String) {
        super.showError(errorMsg)
        mLayoutStatusView?.showError()
    }

    override fun lazyLoad() {
        mPresenter?.getWXChapters()
    }

    override fun scrollToTop() {
        if (weChatPagerAdapter.count == 0) {
            return
        }
        val fragment = weChatPagerAdapter.getItem(viewPager.currentItem) as KnowledgeFragment
        fragment.scrollToTop()
    }

    override fun showWXChapters(chapters: MutableList<WXChapterBean>) {
        chapters.let {
            datas.clear()
            datas.addAll(it)
            viewPager.run {
                adapter = weChatPagerAdapter
                offscreenPageLimit = it.size
            }
        }
        if (chapters.isEmpty()) {
            mLayoutStatusView?.showEmpty()
        } else {
            mLayoutStatusView?.showContent()
        }
    }
}