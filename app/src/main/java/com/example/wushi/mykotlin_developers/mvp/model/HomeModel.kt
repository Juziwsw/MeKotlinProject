package com.example.wushi.mykotlin_developers.mvp.model

import com.example.wushi.mykotlin_developers.http.RetrofitHelper
import com.example.wushi.mykotlin_developers.mvp.contract.HomeContract
import com.example.wushi.mykotlin_developers.mvp.model.bean.Article
import com.example.wushi.mykotlin_developers.mvp.model.bean.ArticleResponseBody
import com.example.wushi.mykotlin_developers.mvp.model.bean.Banner
import com.example.wushi.mykotlin_developers.mvp.model.bean.HttpResult
import io.reactivex.Observable

/**
 * @author wsw
 *
 */
class HomeModel : CommonModel(), HomeContract.Model {
    override fun requestBanner(): Observable<HttpResult<List<Banner>>> {
        return RetrofitHelper.service.getBanners()
    }

    override fun requestTopArticles(): Observable<HttpResult<MutableList<Article>>> {
        return RetrofitHelper.service.getTopArticles()
    }

    override fun requestArticles(num: Int): Observable<HttpResult<ArticleResponseBody>> {
        return RetrofitHelper.service.getArticles(num)
    }
}