package com.example.wushi.mykotlin_developers.mvp.model

import com.example.wushi.mykotlin_developers.mvp.contract.KnowledgeContract
import com.example.wushi.mykotlin_developers.mvp.model.bean.ArticleResponseBody
import com.example.wushi.mykotlin_developers.mvp.model.bean.HttpResult
import io.reactivex.Observable

/**
 * @author wsw
 *
 */
class KnowledgeModel :CommonModel(),KnowledgeContract.Model{
    override fun requestKnowledgeList(page: Int, cid: Int): Observable<HttpResult<ArticleResponseBody>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addCollectArticle(id: Int): Observable<HttpResult<Any>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}