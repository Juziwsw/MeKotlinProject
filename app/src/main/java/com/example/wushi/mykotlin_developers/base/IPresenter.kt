package com.example.wushi.mykotlin_developers.base

/**
 * @author wsw
 *
 */
interface IPresenter<in V : IView> {
    /**
     * 绑定 View
     */
    fun attachView(mView: V)

    /**
     * 解绑 View
     */
    fun detachView()
}