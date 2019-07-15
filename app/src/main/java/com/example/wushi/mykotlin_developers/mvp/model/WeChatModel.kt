package com.example.wushi.mykotlin_developers.mvp.model

import com.example.wushi.mykotlin_developers.base.BaseModel
import com.example.wushi.mykotlin_developers.http.RetrofitHelper
import com.example.wushi.mykotlin_developers.mvp.contract.WeChatContract
import com.example.wushi.mykotlin_developers.mvp.model.bean.HttpResult
import com.example.wushi.mykotlin_developers.mvp.model.bean.WXChapterBean
import io.reactivex.Observable

/**
 * @author wsw
 *
 */
class WeChatModel :BaseModel(),WeChatContract.Model{
    override fun getWXChapters(): Observable<HttpResult<MutableList<WXChapterBean>>> {
        return RetrofitHelper.service.getWXChapters()
    }

}