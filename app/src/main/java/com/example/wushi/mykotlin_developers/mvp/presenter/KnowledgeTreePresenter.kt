package com.example.wushi.mykotlin_developers.mvp.presenter

import com.example.wushi.mykotlin_developers.base.BasePresenter
import com.example.wushi.mykotlin_developers.ext.ss
import com.example.wushi.mykotlin_developers.mvp.contract.KnowledgeTreeContract
import com.example.wushi.mykotlin_developers.mvp.model.KnowledgeTreeModel

/**
 * @author wsw
 *
 */
class KnowledgeTreePresenter : BasePresenter<KnowledgeTreeContract.Model, KnowledgeTreeContract.View>(),
    KnowledgeTreeContract.Presenter {
    override fun createModel(): KnowledgeTreeContract.Model? = KnowledgeTreeModel()

    override fun requestKnowledgeTree() {
        mModel?.requestKnowledgeTree()?.ss(mModel, mView) {
            mView?.setKnowledgeTree(it.data)
        }
    }
}