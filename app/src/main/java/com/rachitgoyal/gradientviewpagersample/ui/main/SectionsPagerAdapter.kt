package com.rachitgoyal.gradientviewpagersample.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.rachitgoyal.gradientviewpagersample.R
import com.rachitgoyal.gradientviewpagersample.model.Pasta


class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val tabData = arrayOf(
        Pasta(context.getString(R.string.penne), context.getString(R.string.penne_desc), R.drawable.penne),
        Pasta(context.getString(R.string.spaghetti), context.getString(R.string.spaghetti_desc), R.drawable.spaghetti),
        Pasta(context.getString(R.string.farfalle), context.getString(R.string.farfalle_desc), R.drawable.farfalle),
        Pasta(context.getString(R.string.fettuccine), context.getString(R.string.fettuccine_desc), R.drawable.fettuccine)
    )

    override fun getItem(position: Int): Fragment {
        return PlaceholderFragment.newInstance(tabData[position])
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabData[position].name
    }

    override fun getCount(): Int {
        return tabData.size
    }
}