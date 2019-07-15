package com.example.wushi.mykotlin_developers.mvp.model

import com.example.wushi.mykotlin_developers.base.BaseModel
import com.example.wushi.mykotlin_developers.http.RetrofitHelper
import com.example.wushi.mykotlin_developers.mvp.contract.KnowledgeTreeContract
import com.example.wushi.mykotlin_developers.mvp.model.bean.HttpResult
import com.example.wushi.mykotlin_developers.mvp.model.bean.KnowledgeTreeBody
import io.reactivex.Observable

/**
 * @author wsw
 *
 */
class KnowledgeTreeModel :BaseModel(),KnowledgeTreeContract.Model{
    override fun requestKnowledgeTree(): Observable<HttpResult<List<KnowledgeTreeBody>>> {
        return RetrofitHelper.service.getKnowledgeTree()
    }

}