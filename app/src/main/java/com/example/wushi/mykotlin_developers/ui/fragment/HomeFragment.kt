package com.example.wushi.mykotlin_developers.ui.fragment

import android.os.Bundle
import com.example.wushi.mykotlin_developers.R
import com.example.wushi.mykotlin_developers.base.BaseMvpFragment
import com.example.wushi.mykotlin_developers.mvp.contract.HomeContract
import com.example.wushi.mykotlin_developers.mvp.presenter.HomePresenter

/**
 * @author wsw
 *
 */
class HomeFragment : BaseMvpFragment<HomeContract.View, HomeContract.Presenter>(), HomeContract.Presenter {

    companion object {
        fun getInstance(type: Int): HomeFragment {
            var bundle = Bundle()
            bundle.putInt("type", type)
            var homeFragment = HomeFragment()
            homeFragment.arguments = bundle
            return homeFragment
        }
    }

    override fun createPresenter(): HomeContract.Presenter = HomePresenter()

    override fun attachLayoutRes(): Int  = R.layout.fragment_home
    override fun lazyLoad() {
    }

    override fun requestBanner() {
    }

    override fun requestHomeData() {
    }

    override fun requestArticles(num: Int) {
    }

    override fun addCollectArticle(id: Int) {
    }

    override fun cancelCollectArticle(id: Int) {
    }

    override fun attachView(mView: HomeContract.View) {
    }

    override fun detachView() {
    }

}