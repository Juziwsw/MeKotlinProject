package com.example.wushi.mykotlin_developers.mvp.model

import com.example.wushi.mykotlin_developers.http.RetrofitHelper
import com.example.wushi.mykotlin_developers.base.BaseModel
import com.example.wushi.mykotlin_developers.mvp.contract.MainContract
import com.example.wushi.mykotlin_developers.mvp.model.bean.HttpResult
import io.reactivex.Observable

/**
 * @author wsw
 *
 */
class MainModel :BaseModel(),MainContract.MainModel{
    override fun logout(): Observable<HttpResult<Any>> {
        return RetrofitHelper.service.logout()
    }

}