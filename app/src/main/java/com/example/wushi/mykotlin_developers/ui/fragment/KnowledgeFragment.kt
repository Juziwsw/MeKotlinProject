package com.example.wushi.mykotlin_developers.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.wushi.mykotlin_developers.R
import com.example.wushi.mykotlin_developers.adapter.KnowledgeAdapter
import com.example.wushi.mykotlin_developers.base.BaseMvpFragment
import com.example.wushi.mykotlin_developers.constant.Constant
import com.example.wushi.mykotlin_developers.mvp.contract.KnowledgeContract
import com.example.wushi.mykotlin_developers.mvp.model.bean.ArticleResponseBody
import com.example.wushi.mykotlin_developers.mvp.presenter.KnowledgePresenter
import com.example.wushi.mykotlin_developers.widget.SpaceItemDecoration
import kotlinx.android.synthetic.main.fragment_refresh_layout.*

/**
 * @author wsw
 *
 */
class KnowledgeFragment : BaseMvpFragment<KnowledgeContract.View, KnowledgeContract.Presenter>(),
    KnowledgeContract.View {
    private var cid: Int = 0
    /**
     * is Refresh
     */
    private var isRefresh = true

    companion object {
        fun getInstance(cid: Int): KnowledgeFragment {
            val fragment = KnowledgeFragment()
            val args = Bundle()
            args.putInt(Constant.CONTENT_CID_KEY, cid)
            fragment.arguments = args
            return fragment
        }
    }

    /**
     * RecyclerView Divider
     */
    private val recyclerViewItemDecoration by lazy {
        activity?.let {
            SpaceItemDecoration(it)
        }
    }
    private val linearLayoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(activity)
    }
    private val knowledgeAdapter: KnowledgeAdapter by lazy {
        KnowledgeAdapter()
    }

    override fun createPresenter(): KnowledgeContract.Presenter = KnowledgePresenter()

    override fun attachLayoutRes(): Int = R.layout.fragment_refresh_layout
    override fun initView(view: View) {
        super.initView(view)
        mLayoutStatusView = multiple_status_view
        cid = arguments?.getInt(Constant.CONTENT_CID_KEY) ?: 0
        recyclerView.run {
            layoutManager = linearLayoutManager
            adapter = knowledgeAdapter
            addItemDecoration(recyclerViewItemDecoration!!)

        }

    }


    override fun lazyLoad() {
        mLayoutStatusView?.showLoading()
        mPresenter?.requestKnowledgeList(0, cid)
    }

    override fun scrollToTop() {
        recyclerView.scrollToPosition(0)
    }

    override fun setKnowledgeList(articles: ArticleResponseBody) {
        articles?.let {
            articles.datas?.let {
                knowledgeAdapter.run {
                    if (isRefresh) {
                        replaceData(it)
                    } else {
                        addData(it)
                    }
                }
            }
        }

        if (knowledgeAdapter.data.isEmpty()) {
            mLayoutStatusView?.showEmpty()
        } else {
            mLayoutStatusView?.showContent()
        }

    }

    override fun showCollectSuccess(success: Boolean) {
    }

    override fun showCancelCollectSuccess(success: Boolean) {
    }
}