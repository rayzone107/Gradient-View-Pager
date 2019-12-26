package com.rachitgoyal.gradientviewpagersample.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

/**
 * Created by Rachit Goyal on 25-12-2019.
 */
@Parcelize
data class Pasta(
    var name: String = "",
    var description: String = "",
    @DrawableRes var imageId: Int = 0
) : Parcelable
