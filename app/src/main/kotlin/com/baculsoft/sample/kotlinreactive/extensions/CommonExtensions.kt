package com.baculsoft.sample.kotlinreactive.extensions

import android.support.v7.widget.Toolbar

internal fun Toolbar.getStatusBarHeight(): Int {
    val resourceId: Int = resources.getIdentifier("status_bar_height", "dimen", "android")
    var result = 0

    when { resourceId > 0 -> result = resources.getDimensionPixelSize(resourceId) }
    return result
}