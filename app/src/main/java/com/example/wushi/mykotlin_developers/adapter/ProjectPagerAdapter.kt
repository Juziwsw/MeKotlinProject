package com.example.wushi.mykotlin_developers.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.wushi.mykotlin_developers.mvp.model.bean.ProjectTreeBean
import com.example.wushi.mykotlin_developers.ui.fragment.ProjectListFragment

/**
 * @author wsw
 *
 */
class ProjectPagerAdapter(private var datas: MutableList<ProjectTreeBean>, fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager) {
    private val fragments = mutableListOf<Fragment>()

    init {
        fragments.clear()
        datas.forEach {
            fragments.add(ProjectListFragment.getInstance(it.id))
        }

    }

    override fun getItem(p0: Int): Fragment {
        return fragments[p0]
    }

    override fun getCount(): Int {
        return datas.size

    }

    override fun getPageTitle(position: Int): CharSequence? {
        return datas[position].name
    }


}