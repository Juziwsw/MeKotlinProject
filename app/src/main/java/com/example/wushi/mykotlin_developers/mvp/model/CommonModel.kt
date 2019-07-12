package com.example.wushi.mykotlin_developers.mvp.model

import com.example.wushi.mykotlin_developers.base.BaseModel
import com.example.wushi.mykotlin_developers.http.RetrofitHelper
import com.example.wushi.mykotlin_developers.mvp.contract.CommonContract
import com.example.wushi.mykotlin_developers.mvp.model.bean.HttpResult
import io.reactivex.Observable

/**
 * @author wsw
 *
 */
open class CommonModel : BaseModel(), CommonContract.Model {
    override fun addCollectArticle(id: Int): Observable<HttpResult<Any>> {
        return RetrofitHelper.service.addCollectArticle(id)
    }

    override fun cancelCollectArticle(id: Int): Observable<HttpResult<Any>> {
        return RetrofitHelper.service.cancelCollectArticle(id)
    }
}