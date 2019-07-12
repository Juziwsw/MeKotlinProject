package com.example.wushi.mykotlin_developers.mvp.presenter

import com.example.wushi.mykotlin_developers.base.BasePresenter
import com.example.wushi.mykotlin_developers.ext.ss
import com.example.wushi.mykotlin_developers.mvp.contract.MainContract
import com.example.wushi.mykotlin_developers.mvp.model.MainModel

/**
 * @author wsw
 *
 */
class MainPresenter :BasePresenter<MainContract.MainModel,MainContract.MainView>(),MainContract.MainPresenter{
    override fun createModel(): MainContract.MainModel?  = MainModel()

    override fun logout() {
        mModel?.logout()?.ss(mModel,mView){
            mView?.showLogoutSuccess(success = true)
        }
    }

}