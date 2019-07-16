package com.example.wushi.mykotlin_developers.mvp.model

import com.example.wushi.mykotlin_developers.http.RetrofitHelper
import com.example.wushi.mykotlin_developers.mvp.contract.ProjectListContract
import com.example.wushi.mykotlin_developers.mvp.model.bean.ArticleResponseBody
import com.example.wushi.mykotlin_developers.mvp.model.bean.HttpResult
import io.reactivex.Observable

/**
 * @author wsw
 *
 */
class ProjectListModel :CommonModel(),ProjectListContract.Model{
    override fun requestProjectList(page: Int, cid: Int): Observable<HttpResult<ArticleResponseBody>> {
        return RetrofitHelper.service.getProjectList(page, cid)
    }


}