package com.example.wushi.mykotlin_developers.mvp.contract

import com.example.wushi.mykotlin_developers.base.IPresenter
import com.example.wushi.mykotlin_developers.base.IView
import com.example.wushi.mykotlin_developers.mvp.model.bean.Article
import com.example.wushi.mykotlin_developers.mvp.model.bean.ArticleResponseBody
import com.example.wushi.mykotlin_developers.mvp.model.bean.Banner
import com.example.wushi.mykotlin_developers.mvp.model.bean.HttpResult
import io.reactivex.Observable

/**
 * @author wsw
 *
 */
interface HomeContract {
    interface View : CommonContract.View {

        fun scrollToTop()

        fun setBanner(banners: List<Banner>)

        fun setArticles(articles: ArticleResponseBody)
    }

    interface Presenter : CommonContract.Presenter<View> {
        fun requestBanner()

        fun requestHomeData()

        fun requestArticles(num: Int)
    }

    interface Model : CommonContract.Model {
        fun requestBanner(): Observable<HttpResult<List<Banner>>>

        fun requestTopArticles(): Observable<HttpResult<MutableList<Article>>>

        fun requestArticles(num: Int): Observable<HttpResult<ArticleResponseBody>>
    }
}