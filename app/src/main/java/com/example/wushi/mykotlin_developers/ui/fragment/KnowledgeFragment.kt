package com.example.wushi.mykotlin_developers.ui.fragment

import com.example.wushi.mykotlin_developers.base.BaseMvpFragment
import com.example.wushi.mykotlin_developers.mvp.contract.KnowledgeContract
import com.example.wushi.mykotlin_developers.mvp.model.bean.ArticleResponseBody

/**
 * @author wsw
 *
 */
class KnowledgeFragment :BaseMvpFragment<KnowledgeContract.View,KnowledgeContract.Presenter>(),KnowledgeContract.View{
    override fun createPresenter(): KnowledgeContract.Presenter {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun attachLayoutRes(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun lazyLoad() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun scrollToTop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setKnowledgeList(articles: ArticleResponseBody) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showCollectSuccess(success: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showCancelCollectSuccess(success: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}