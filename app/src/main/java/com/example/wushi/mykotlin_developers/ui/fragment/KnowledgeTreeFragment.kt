package com.example.wushi.mykotlin_developers.ui.fragment


import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.wushi.mykotlin_developers.R
import com.example.wushi.mykotlin_developers.adapter.KnowledgeTreeAdapter
import com.example.wushi.mykotlin_developers.base.BaseMvpFragment
import com.example.wushi.mykotlin_developers.ext.showToast
import com.example.wushi.mykotlin_developers.mvp.contract.KnowledgeTreeContract
import com.example.wushi.mykotlin_developers.mvp.model.bean.KnowledgeTreeBody
import com.example.wushi.mykotlin_developers.mvp.presenter.KnowledgeTreePresenter
import com.example.wushi.mykotlin_developers.widget.RecyclerViewItemDecoration
import kotlinx.android.synthetic.main.fragment_refresh_layout.*

class KnowledgeTreeFragment : BaseMvpFragment<KnowledgeTreeContract.View, KnowledgeTreeContract.Presenter>(),
    KnowledgeTreeContract.View {
    private val knowledgeTreeAdapter: KnowledgeTreeAdapter by lazy {
        KnowledgeTreeAdapter(activity)
    }
    private val linearLayoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(activity)
    }
    /**
     * RecyclerView Divider
     */
    private val recyclerViewItemDecoration by lazy {
        activity?.let {
            RecyclerViewItemDecoration(it, LinearLayoutManager.VERTICAL)
        }
    }


    companion object {
        fun getInstance() = KnowledgeTreeFragment()
    }


    override fun createPresenter(): KnowledgeTreeContract.Presenter = KnowledgeTreePresenter()

    override fun attachLayoutRes(): Int = R.layout.fragment_refresh_layout

    override fun initView(view: View) {
        super.initView(view)
        mLayoutStatusView = multiple_status_view
        recyclerView?.run {
            layoutManager = linearLayoutManager
            adapter = knowledgeTreeAdapter
            itemAnimator = DefaultItemAnimator()
            addItemDecoration(recyclerViewItemDecoration!!)
        }
        knowledgeTreeAdapter.run {
            onItemClickListener = onItemOnClick
        }
    }

    override fun lazyLoad() {
        mLayoutStatusView?.showLoading()
        mPresenter?.requestKnowledgeTree()
    }

    override fun scrollToTop() {
    }

    override fun setKnowledgeTree(lists: List<KnowledgeTreeBody>) {
        lists?.let {
            knowledgeTreeAdapter.replaceData(it)
        }
        if (knowledgeTreeAdapter.data.isEmpty()) {
            mLayoutStatusView?.showEmpty()
        } else {
            mLayoutStatusView?.showContent()
        }

    }
    private val onItemOnClick = BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
        adapter.data[position].let {
            showToast(it.toString())
        }

    }

}