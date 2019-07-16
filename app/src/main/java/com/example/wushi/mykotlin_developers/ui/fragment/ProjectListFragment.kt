package com.example.wushi.mykotlin_developers.ui.fragment

import android.os.Bundle
import android.view.View
import com.example.wushi.mykotlin_developers.R
import com.example.wushi.mykotlin_developers.base.BaseMvpFragment
import com.example.wushi.mykotlin_developers.constant.Constant
import com.example.wushi.mykotlin_developers.mvp.contract.ProjectListContract
import com.example.wushi.mykotlin_developers.mvp.model.bean.ArticleResponseBody
import com.example.wushi.mykotlin_developers.mvp.presenter.ProjectListPresenter

/**
 * @author wsw
 *
 */
class ProjectListFragment : BaseMvpFragment<ProjectListContract.View, ProjectListContract.Presenter>(),
    ProjectListContract.View {
    private val cid: Int = 0

    companion object {
        fun getInstance(id: Int): ProjectListFragment {
            val mFragment = ProjectListFragment()
            val bundle = Bundle()
            bundle.putInt(Constant.CONTENT_CID_KEY, id)
            mFragment.arguments = bundle
            return mFragment
        }
    }

    override fun attachLayoutRes(): Int = R.layout.fragment_refresh_layout

    override fun initView(view: View) {
        super.initView(view)
    }

    override fun lazyLoad() {
    }
    override fun createPresenter(): ProjectListContract.Presenter = ProjectListPresenter()

    override fun scrollToTop() {
    }

    override fun setProjectList(articles: ArticleResponseBody) {
    }

    override fun showCollectSuccess(success: Boolean) {
    }

    override fun showCancelCollectSuccess(success: Boolean) {
    }



}