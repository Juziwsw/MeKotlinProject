package com.example.wushi.mykotlin_developers.mvp.contract

import com.example.wushi.mykotlin_developers.base.IModel
import com.example.wushi.mykotlin_developers.base.IPresenter
import com.example.wushi.mykotlin_developers.base.IView
import com.example.wushi.mykotlin_developers.mvp.model.bean.HttpResult
import com.example.wushi.mykotlin_developers.mvp.model.bean.WXChapterBean
import io.reactivex.Observable

/**
 * @author wsw
 *
 */
interface WeChatContract {
    interface View : IView {

        fun scrollToTop()

        fun showWXChapters(chapters: MutableList<WXChapterBean>)

    }

    interface Presenter : IPresenter<View> {
        fun getWXChapters()
    }

    interface Model : IModel {
        fun getWXChapters(): Observable<HttpResult<MutableList<WXChapterBean>>>
    }
}