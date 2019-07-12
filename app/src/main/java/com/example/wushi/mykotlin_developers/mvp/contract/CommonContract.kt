package com.example.wushi.mykotlin_developers.mvp.contract

import com.example.wushi.mykotlin_developers.base.IModel
import com.example.wushi.mykotlin_developers.base.IPresenter
import com.example.wushi.mykotlin_developers.base.IView
import com.example.wushi.mykotlin_developers.mvp.model.bean.HttpResult
import io.reactivex.Observable

/**
 * Created by chenxz on 2018/6/10.
 */
interface CommonContract {

    interface View : IView {

        fun showCollectSuccess(success: Boolean)

        fun showCancelCollectSuccess(success: Boolean)
    }

    interface Presenter<in V : View> : IPresenter<V> {

        fun addCollectArticle(id: Int)

        fun cancelCollectArticle(id: Int)

    }

    interface Model : IModel {

        fun addCollectArticle(id: Int): Observable<HttpResult<Any>>

        fun cancelCollectArticle(id: Int): Observable<HttpResult<Any>>

    }

}