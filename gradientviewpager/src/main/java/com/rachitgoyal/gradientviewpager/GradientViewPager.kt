package com.rachitgoyal.gradientviewpager

import android.animation.ArgbEvaluator
import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager

/**
 * Created by Rachit Goyal on 25-12-2019.
 */
class GradientViewPager : ViewPager {

    var argbEvaluator: ArgbEvaluator = ArgbEvaluator()
    public var colorArray: MutableList<PageColor> = mutableListOf()

    constructor(context: Context) : super(context) {
        initCustomViewPagerOnPageChangeListener()
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        initCustomViewPagerOnPageChangeListener()
    }

    private fun initCustomViewPagerOnPageChangeListener() {
        addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                posOffsetPixels: Int
            ) {
                if (colorArray.size > position + 1) {
                    if (positionOffset == 0f) {
                        background = GradientDrawable(
                            GradientDrawable.Orientation.TOP_BOTTOM,
                            colorArray[position].colorMiddle?.let {
                                intArrayOf(
                                    ContextCompat.getColor(context, colorArray[position].colorTop),
                                    ContextCompat.getColor(context, it),
                                    ContextCompat.getColor(context, colorArray[position].colorBottom)
                                )
                            } ?: intArrayOf(
                                ContextCompat.getColor(context, colorArray[position].colorTop),
                                ContextCompat.getColor(context, colorArray[position].colorBottom)
                            )
                        )
                    } else {
                        val colorTop = argbEvaluator.evaluate(
                            positionOffset,
                            ContextCompat.getColor(context, colorArray[position].colorTop),
                            ContextCompat.getColor(context, colorArray[position + 1].colorTop)
                        ) as Int

                        var colorMiddle: Int? = null
                        colorArray[position].colorMiddle?.let {
                            colorArray[position + 1].colorMiddle?.let {
                                colorMiddle = argbEvaluator.evaluate(
                                    positionOffset,
                                    ContextCompat.getColor(context, colorArray[position].colorMiddle!!),
                                    ContextCompat.getColor(context, colorArray[position + 1].colorMiddle!!)
                                ) as Int
                            } ?: run {
                                val secondColorMiddle: Int = argbEvaluator.evaluate(
                                    0.5F,
                                    colorArray[position + 1].colorTop,
                                    colorArray[position + 1].colorBottom
                                ) as Int
                                colorMiddle = argbEvaluator.evaluate(
                                    positionOffset,
                                    ContextCompat.getColor(context, colorArray[position].colorMiddle!!),
                                    ContextCompat.getColor(context, secondColorMiddle)
                                ) as Int
                            }
                        } ?: run {
                            val firstColorMiddle: Int = argbEvaluator.evaluate(
                                0.5F,
                                colorArray[position].colorTop,
                                colorArray[position].colorBottom
                            ) as Int
                            colorArray[position + 1].colorMiddle?.let {
                                colorMiddle = argbEvaluator.evaluate(
                                    positionOffset,
                                    ContextCompat.getColor(context, firstColorMiddle),
                                    ContextCompat.getColor(context, colorArray[position + 1].colorMiddle!!)
                                ) as Int
                            }
                        }

                        val colorBottom = argbEvaluator.evaluate(
                            positionOffset,
                            ContextCompat.getColor(context, colorArray[position].colorBottom),
                            ContextCompat.getColor(context, colorArray[position + 1].colorBottom)
                        ) as Int

                        background = GradientDrawable(
                            GradientDrawable.Orientation.TOP_BOTTOM,
                            colorMiddle?.let {
                                intArrayOf(colorTop, it, colorBottom)
                            } ?: intArrayOf(colorTop, colorBottom)
                        )
                    }
                } else if (colorArray.size > position) {
                    if (positionOffset == 0f) {
                        background = GradientDrawable(
                            GradientDrawable.Orientation.TOP_BOTTOM,
                            colorArray[position].colorMiddle?.let {
                                intArrayOf(
                                    ContextCompat.getColor(context, colorArray[position].colorTop),
                                    ContextCompat.getColor(context, it),
                                    ContextCompat.getColor(context, colorArray[position].colorBottom)
                                )
                            } ?: intArrayOf(
                                ContextCompat.getColor(context, colorArray[position].colorTop),
                                ContextCompat.getColor(context, colorArray[position].colorBottom)
                            )
                        )
                    } else {
                        val colorTop = argbEvaluator.evaluate(
                            positionOffset,
                            ContextCompat.getColor(context, colorArray[position].colorTop),
                            ContextCompat.getColor(context, R.color.white)
                        ) as Int

                        var colorMiddle: Int? = null
                        colorArray[position].colorMiddle?.let {
                            colorMiddle = argbEvaluator.evaluate(
                                positionOffset,
                                ContextCompat.getColor(context, colorArray[position].colorMiddle!!),
                                ContextCompat.getColor(context, R.color.white)
                            ) as Int
                        } ?: run {
                            val firstColorMiddle: Int = argbEvaluator.evaluate(
                                0.5F,
                                colorArray[position].colorTop,
                                colorArray[position].colorBottom
                            ) as Int
                            colorMiddle = argbEvaluator.evaluate(
                                positionOffset,
                                ContextCompat.getColor(context, firstColorMiddle),
                                ContextCompat.getColor(context, R.color.white)
                            ) as Int
                        }

                        val colorBottom = argbEvaluator.evaluate(
                            positionOffset,
                            ContextCompat.getColor(context, colorArray[position].colorBottom),
                            ContextCompat.getColor(context, R.color.white)
                        ) as Int

                        background = GradientDrawable(
                            GradientDrawable.Orientation.TOP_BOTTOM,
                            colorMiddle?.let {
                                intArrayOf(colorTop, it, colorBottom)
                            } ?: intArrayOf(colorTop, colorBottom)
                        )
                    }
                } else {
                    setBackgroundColor(ContextCompat.getColor(context, R.color.white))
                }
            }

            override fun onPageSelected(position: Int) {
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })
    }
}
