package com.example.wushi.mykotlin_developers.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.wushi.mykotlin_developers.R
import com.example.wushi.mykotlin_developers.mvp.model.bean.Article

/**
 * @author wsw
 *
 */
class KnowledgeAdapter : BaseQuickAdapter<Article, BaseViewHolder>(R.layout.item_knowledge_list) {
    override fun convert(helper: BaseViewHolder?, item: Article?) {
        item ?: return
        helper?.run {
            setGone(R.id.iv_article_thumbnail, false)
            setText(R.id.tv_article_author, item.author)
            setText(R.id.tv_article_date, item.niceDate)
            setText(R.id.tv_article_title, item.title)
            var articleChapterName = StringBuilder()
            if (item.superChapterName.isNotEmpty()) {
                articleChapterName?.append(item.superChapterName)
            }
            if (item.chapterName.isNotEmpty()) {
                articleChapterName.append("/" + item.chapterName)
            }
            setText(R.id.tv_article_chapterName, articleChapterName.toString())
        }
        //用with 也要用this去代替,没必要这么些
        /*with(item) {

        }*/


    }

}