package com.example.wushi.mykotlin_developers.ui.fragment

import android.view.View
import com.example.wushi.mykotlin_developers.R
import com.example.wushi.mykotlin_developers.adapter.ProjectPagerAdapter
import com.example.wushi.mykotlin_developers.base.BaseMvpFragment
import com.example.wushi.mykotlin_developers.mvp.contract.ProjectContract
import com.example.wushi.mykotlin_developers.mvp.model.bean.ProjectTreeBean
import com.example.wushi.mykotlin_developers.mvp.presenter.ProjectPresenter
import kotlinx.android.synthetic.main.fragment_project.*

/**
 * @author wsw
 * 项目
 */
class ProjectFragment : BaseMvpFragment<ProjectContract.View, ProjectContract.Presenter>(), ProjectContract.View {
    companion object {
        fun getInstance() = ProjectFragment()
    }

    private var datas = mutableListOf<ProjectTreeBean>()
    private val projectPagerAdapter: ProjectPagerAdapter by lazy {
        ProjectPagerAdapter(datas, childFragmentManager)
    }

    override fun attachLayoutRes(): Int = R.layout.fragment_project

    override fun initView(view: View) {
        super.initView(view)
        mLayoutStatusView = multiple_status_view
        tabLayout.run {
            setupWithViewPager(viewPager)
        }
    }

    override fun showLoading() {
        super.showLoading()
        mLayoutStatusView?.showLoading()

    }

    override fun lazyLoad() {
        mPresenter?.requestProjectTree()
    }

    override fun createPresenter(): ProjectContract.Presenter = ProjectPresenter()

    override fun scrollToTop() {
    }

    override fun setProjectTree(list: List<ProjectTreeBean>) {
        list.let {
            datas.clear()
            datas.addAll(list)
            viewPager.run {
                adapter = projectPagerAdapter
                offscreenPageLimit = it.size
            }
        }
        if (projectPagerAdapter.count != 0) {
            mLayoutStatusView?.showContent()
        } else {
            mLayoutStatusView?.showEmpty()
        }

    }


}