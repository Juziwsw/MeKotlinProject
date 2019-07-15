package com.example.wushi.mykotlin_developers.mvp.presenter

import com.example.wushi.mykotlin_developers.base.BasePresenter
import com.example.wushi.mykotlin_developers.ext.ss
import com.example.wushi.mykotlin_developers.mvp.contract.WeChatContract
import com.example.wushi.mykotlin_developers.mvp.model.WeChatModel

/**
 * @author wsw
 *
 */
class WeChatPresenter : BasePresenter<WeChatContract.Model, WeChatContract.View>(), WeChatContract.Presenter {
    override fun createModel(): WeChatContract.Model? = WeChatModel()

    override fun getWXChapters() {
        mModel?.getWXChapters()?.ss(mModel, mView) {
            mView?.showWXChapters(it.data)
        }
    }

}