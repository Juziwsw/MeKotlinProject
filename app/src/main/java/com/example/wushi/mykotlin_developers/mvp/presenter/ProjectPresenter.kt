package com.example.wushi.mykotlin_developers.mvp.presenter

import com.example.wushi.mykotlin_developers.base.BasePresenter
import com.example.wushi.mykotlin_developers.ext.ss
import com.example.wushi.mykotlin_developers.mvp.contract.ProjectContract
import com.example.wushi.mykotlin_developers.mvp.model.ProjectModel

/**
 * @author wsw
 *
 */
class ProjectPresenter : BasePresenter<ProjectContract.Model, ProjectContract.View>(), ProjectContract.Presenter {
    override fun createModel(): ProjectContract.Model? = ProjectModel()

    override fun requestProjectTree() {
        mModel?.requestProjectTree()?.ss(mModel, mView) {
            mView?.setProjectTree(it.data)
        }
    }

}