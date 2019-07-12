package com.example.wushi.mykotlin_developers.base

import com.example.wushi.mykotlin_developers.ext.showToast

/**
 * @author wsw
 *
 */
abstract class BaseMvpActivity<V : IView, P : IPresenter<V>> : BaseActivity(), IView {
    private var mPresenter: P? = null
    protected abstract fun createPresenter(): P

    override fun initView() {
        mPresenter = createPresenter()
        mPresenter?.attachView(this as V)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.detachView()
        mPresenter = null
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun showError(errorMsg: String) {
        showToast(errorMsg)
    }

    override fun showDefaultMsg(msg: String) {
        showToast(msg)
    }

    override fun showMsg(msg: String) {
        showToast(msg)
    }
}