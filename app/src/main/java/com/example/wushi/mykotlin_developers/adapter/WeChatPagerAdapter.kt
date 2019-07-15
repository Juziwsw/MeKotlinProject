package com.example.wushi.mykotlin_developers.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.wushi.mykotlin_developers.mvp.model.bean.WXChapterBean

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
    override fun getItem(p0: Int): Fragment {

    }

    override fun getCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}