package com.example.wushi.mykotlin_developers.mvp.contract

import com.example.wushi.mykotlin_developers.base.IModel
import com.example.wushi.mykotlin_developers.base.IPresenter
import com.example.wushi.mykotlin_developers.base.IView
import com.example.wushi.mykotlin_developers.mvp.model.bean.HttpResult
import io.reactivex.Observable

/**
 * @author wsw
 *
 */
interface MainContract {
    interface MainView : IView {
        fun showLogoutSuccess(success: Boolean)
    }

    interface MainPresenter : IPresenter<MainView> {
        fun logout()
    }

    interface MainModel : IModel {
        fun logout(): Observable<HttpResult<Any>>
    }
}