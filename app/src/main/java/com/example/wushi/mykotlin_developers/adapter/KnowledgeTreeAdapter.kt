package com.example.wushi.mykotlin_developers.adapter

import android.content.Context
import android.text.Html
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.wushi.mykotlin_developers.R
import com.example.wushi.mykotlin_developers.mvp.model.bean.KnowledgeTreeBody

/**
 * @author wsw
 *
 */
class KnowledgeTreeAdapter(context: Context?) :
    BaseQuickAdapter<KnowledgeTreeBody, BaseViewHolder>(R.layout.item_knowledge_tree_list) {
    override fun convert(helper: BaseViewHolder?, item: KnowledgeTreeBody?) {
        helper?.setText(R.id.title_first, item?.name)
        item?.children.let {
            helper?.setText(R.id.title_second,it?.joinToString("   ", transform ={
                    str -> Html.fromHtml(str.name) }))
        }


    }

}