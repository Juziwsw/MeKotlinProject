package com.example.wushi.mykotlin_developers.mvp.presenter

import com.example.wushi.mykotlin_developers.base.BasePresenter
import com.example.wushi.mykotlin_developers.mvp.contract.CommonContract

/**
 * @author wsw
 *
 */
abstract class CommonPresenter<M : CommonContract.Model, V : CommonContract.View> : BasePresenter<M, V>(),
    CommonContract.Presenter<V> {

    override fun addCollectArticle(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun cancelCollectArticle(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}