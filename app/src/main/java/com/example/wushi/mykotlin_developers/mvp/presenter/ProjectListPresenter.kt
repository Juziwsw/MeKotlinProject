package com.example.wushi.mykotlin_developers.mvp.presenter

import com.example.wushi.mykotlin_developers.ext.ss
import com.example.wushi.mykotlin_developers.mvp.contract.ProjectListContract
import com.example.wushi.mykotlin_developers.mvp.model.ProjectListModel

/**
 * @author wsw
 *
 */
class ProjectListPresenter :CommonPresenter<ProjectListContract.Model,ProjectListContract.View>(),ProjectListContract.Presenter{
    override fun createModel(): ProjectListContract.Model? = ProjectListModel()

    override fun requestProjectList(page: Int, cid: Int) {
        mModel?.requestProjectList(page, cid)?.ss(mModel, mView, page == 1) {
            mView?.setProjectList(it.data)
        }
    }

}