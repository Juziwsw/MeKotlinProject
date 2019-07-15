package com.example.wushi.mykotlin_developers.mvp.presenter

import com.example.wushi.mykotlin_developers.ext.ss
import com.example.wushi.mykotlin_developers.mvp.contract.HomeContract
import com.example.wushi.mykotlin_developers.mvp.model.HomeModel
import com.example.wushi.mykotlin_developers.mvp.model.bean.Article
import com.example.wushi.mykotlin_developers.mvp.model.bean.ArticleResponseBody
import com.example.wushi.mykotlin_developers.mvp.model.bean.HttpResult
import com.example.wushi.mykotlin_developers.utils.SettingUtil
import io.reactivex.Observable
import io.reactivex.functions.BiFunction

/**
 * @author wsw
 *
 */
class HomePresenter : CommonPresenter<HomeContract.Model, HomeContract.View>(), HomeContract.Presenter {
    override fun createModel(): HomeContract.Model? = HomeModel()
    /**
     * 获取banner内容
     */
    override fun requestBanner() {
        //这么写为了拿到model中调用网络的方法
        mModel?.requestBanner()?.ss(mModel, mView) {
            mView?.setBanner(it.data)
        }
    }

    /**
     * 获取首页全部内容
     * 都在这里调用,下面的只做分页
     */
    override fun requestHomeData() {
        requestBanner()
        val observable = if (SettingUtil.getIsShowTopArticle()) {
            mModel?.requestArticles(0)
        } else {
            Observable.zip(mModel?.requestTopArticles(), mModel?.requestArticles(0),
                BiFunction<HttpResult<MutableList<Article>>, HttpResult<ArticleResponseBody>,
                        HttpResult<ArticleResponseBody>> { t1, t2 ->
                    t1.data.forEach {
                        // 置顶数据中没有标识，手动添加一个标识
                        it.top = "1"
                    }
                    t2.data.datas.addAll(0, t1.data)
                    t2
                })
        }
        observable?.ss(mModel, mView) {
            mView?.setArticles(it.data)
        }
    }

    override fun requestArticles(num: Int) {
        mModel?.requestArticles(num)?.ss(mModel, mView) {
            mView?.setArticles(it.data)
        }
    }

}