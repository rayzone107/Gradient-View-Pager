package com.rachitgoyal.gradientviewpagersample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.rachitgoyal.gradientviewpager.GradientViewPager
import com.rachitgoyal.gradientviewpager.PageColor
import com.rachitgoyal.gradientviewpagersample.ui.main.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: GradientViewPager = findViewById(R.id.view_pager)

        val colorArray = mutableListOf<PageColor>()
        colorArray.add(
            PageColor(
                R.color.screen_1_top,
                R.color.screen_1_bottom
//                R.color.screen_1_middle
            )
        )
        colorArray.add(
            PageColor(
                R.color.screen_2_top,
                R.color.screen_2_bottom,
                R.color.screen_2_middle
            )
        )
        colorArray.add(
            PageColor(
                R.color.screen_3_top,
                R.color.screen_3_bottom
//                R.color.screen_3_middle
            )
        )
        viewPager.colorArray = colorArray

        viewPager.clipToPadding = false
        viewPager.setPadding(100, 0, 100, 0)
        viewPager.pageMargin = 40

        viewPager.adapter = sectionsPagerAdapter

        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
    }
}
