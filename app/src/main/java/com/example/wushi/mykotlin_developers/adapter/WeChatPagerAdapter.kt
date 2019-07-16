package com.example.wushi.mykotlin_developers.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.wushi.mykotlin_developers.mvp.model.bean.WXChapterBean
import com.example.wushi.mykotlin_developers.ui.fragment.KnowledgeFragment

/**
 * @author wsw
 *
 */
class WeChatPagerAdapter(private val list: MutableList<WXChapterBean>, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragments = mutableListOf<Fragment>()

    init {
        fragments.clear()
        list.forEach {
            fragments.add(KnowledgeFragment.getInstance(it.id))
        }
    }

    override fun getItem(p0: Int): Fragment = fragments[p0]

    override fun getCount(): Int = list.size

    override fun getPageTitle(position: Int): CharSequence? = list[position].name


}