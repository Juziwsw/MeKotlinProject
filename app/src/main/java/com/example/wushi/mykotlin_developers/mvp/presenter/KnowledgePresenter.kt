package com.example.wushi.mykotlin_developers.mvp.presenter

import com.example.wushi.mykotlin_developers.ext.ss
import com.example.wushi.mykotlin_developers.mvp.contract.KnowledgeContract
import com.example.wushi.mykotlin_developers.mvp.model.KnowledgeModel

/**
 * @author wsw
 *
 */
class KnowledgePresenter :CommonPresenter<KnowledgeContract.Model,KnowledgeContract.View>(),KnowledgeContract.Presenter{
    override fun createModel(): KnowledgeContract.Model?  = KnowledgeModel()

    override fun requestKnowledgeList(page: Int, cid: Int) {
        mModel?.requestKnowledgeList(page,cid)?.ss(mModel,mView){
            mView?.setKnowledgeList(it.data)
        }
    }


}