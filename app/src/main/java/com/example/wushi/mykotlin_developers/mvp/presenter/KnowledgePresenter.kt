package com.example.wushi.mykotlin_developers.mvp.presenter

import com.example.wushi.mykotlin_developers.base.BasePresenter
import com.example.wushi.mykotlin_developers.mvp.contract.KnowledgeContract

/**
 * @author wsw
 *
 */
class KnowledgePresenter :BasePresenter<KnowledgeContract.Model,KnowledgeContract.View>(),KnowledgeContract.Presenter{
    override fun createModel(): KnowledgeContract.Model? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun requestKnowledgeList(page: Int, cid: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addCollectArticle(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun cancelCollectArticle(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}