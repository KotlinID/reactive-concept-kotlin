package com.baculsoft.sample.kotlinreactive.extensions

import android.support.v7.widget.Toolbar

internal fun Toolbar.getStatusBarHeight(): Int {
    val resourceId: Int = resources.getIdentifier("status_bar_height", "dimen", "android")
    var result: Int = 0

    if (resourceId > 0) {
        result = resources.getDimensionPixelSize(resourceId)
    }

    return result
}