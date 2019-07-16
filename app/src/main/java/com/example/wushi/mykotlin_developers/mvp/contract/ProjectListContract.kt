package com.example.wushi.mykotlin_developers.mvp.contract

import com.example.wushi.mykotlin_developers.mvp.model.bean.ArticleResponseBody
import com.example.wushi.mykotlin_developers.mvp.model.bean.HttpResult
import io.reactivex.Observable

/**
 * @author wsw
 * 这里因为要用到添加喜欢和取消喜欢,继承Comm
 */
interface ProjectListContract {
    interface View : CommonContract.View {

        fun scrollToTop()

        fun setProjectList(articles: ArticleResponseBody)

    }

    interface Presenter : CommonContract.Presenter<View> {

        fun requestProjectList(page: Int, cid: Int)

    }

    interface Model : CommonContract.Model {

        fun requestProjectList(page: Int, cid: Int): Observable<HttpResult<ArticleResponseBody>>

    }
}