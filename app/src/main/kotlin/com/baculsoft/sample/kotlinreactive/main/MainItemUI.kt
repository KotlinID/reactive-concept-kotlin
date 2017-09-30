package com.baculsoft.sample.kotlinreactive.main

import android.support.v4.content.ContextCompat
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import com.baculsoft.sample.kotlinreactive.R
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.backgroundResource
import org.jetbrains.anko.dip
import org.jetbrains.anko.margin
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.padding
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.textColor
import org.jetbrains.anko.textView
import org.jetbrains.anko.wrapContent

class MainItemUI : AnkoComponent<ViewGroup> {

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        val typedValue: TypedValue = TypedValue()

        relativeLayout {
            ctx.theme.resolveAttribute(android.R.attr.selectableItemBackground, typedValue, true)
            backgroundResource = typedValue.resourceId
            isClickable = true
            padding = dip(8)
            lparams(width = matchParent, height = wrapContent)

            textView {
                id = R.id.tv_main_menu
                textColor = ContextCompat.getColor(ctx, R.color.colorPrimaryDark)
                textSize = 16f
            }.lparams {
                width = matchParent
                height = wrapContent
                margin = dip(8)
            }
        }
    }
}