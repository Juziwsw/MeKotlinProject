package com.example.wushi.mykotlin_developers.mvp.contract

import com.example.wushi.mykotlin_developers.base.IModel
import com.example.wushi.mykotlin_developers.base.IPresenter
import com.example.wushi.mykotlin_developers.base.IView
import com.example.wushi.mykotlin_developers.mvp.model.bean.HttpResult
import com.example.wushi.mykotlin_developers.mvp.model.bean.ProjectTreeBean
import io.reactivex.Observable

/**
 * @author wsw
 *
 */
interface ProjectContract {
    interface View : IView {

        fun scrollToTop()

        fun setProjectTree(list: List<ProjectTreeBean>)

    }

    interface Presenter : IPresenter<View> {

        fun requestProjectTree()

    }

    interface Model : IModel {
        fun requestProjectTree(): Observable<HttpResult<List<ProjectTreeBean>>>
    }
}