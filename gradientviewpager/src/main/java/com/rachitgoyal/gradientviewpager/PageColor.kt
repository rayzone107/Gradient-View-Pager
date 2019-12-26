package com.rachitgoyal.gradientviewpager

import androidx.annotation.ColorRes

/**
 * Created by Rachit Goyal on 25-12-2019.
 */
data class PageColor(
    @ColorRes var colorTop: Int,
    @ColorRes var colorBottom: Int,
    @ColorRes var colorMiddle: Int? = null
)
