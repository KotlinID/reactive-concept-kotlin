package com.baculsoft.sample.kotlinreactive.ext

import android.support.v7.widget.Toolbar

internal val Toolbar.statusBarHeight: Int
    get() {
        val resourceId: Int = resources.getIdentifier("status_bar_height", "dimen", "android")

        return when {
            resourceId > 0 -> resources.getDimensionPixelSize(resourceId)
            else -> 0
        }
    }