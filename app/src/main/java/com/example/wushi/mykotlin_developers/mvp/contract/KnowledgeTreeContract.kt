package com.example.wushi.mykotlin_developers.mvp.contract

import com.example.wushi.mykotlin_developers.base.IModel
import com.example.wushi.mykotlin_developers.base.IPresenter
import com.example.wushi.mykotlin_developers.base.IView
import com.example.wushi.mykotlin_developers.mvp.model.bean.HttpResult
import com.example.wushi.mykotlin_developers.mvp.model.bean.KnowledgeTreeBody
import io.reactivex.Observable

interface KnowledgeTreeContract {
    interface View : IView {
        fun scrollToTop()

        fun setKnowledgeTree(lists: List<KnowledgeTreeBody>)
    }

    interface Presenter : IPresenter<View> {
        fun requestKnowledgeTree()
    }

    interface Model : IModel {
        fun requestKnowledgeTree(): Observable<HttpResult<List<KnowledgeTreeBody>>>
    }
}