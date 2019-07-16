package com.example.wushi.mykotlin_developers.mvp.model

import com.example.wushi.mykotlin_developers.base.BaseModel
import com.example.wushi.mykotlin_developers.http.RetrofitHelper
import com.example.wushi.mykotlin_developers.mvp.contract.ProjectContract
import com.example.wushi.mykotlin_developers.mvp.model.bean.HttpResult
import com.example.wushi.mykotlin_developers.mvp.model.bean.ProjectTreeBean
import io.reactivex.Observable

/**
 * @author wsw
 *
 */
class ProjectModel : BaseModel(), ProjectContract.Model {
    override fun requestProjectTree(): Observable<HttpResult<List<ProjectTreeBean>>> {
        return RetrofitHelper.service.getProjectTree()
    }

}