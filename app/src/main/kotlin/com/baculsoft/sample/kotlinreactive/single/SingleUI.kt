package com.baculsoft.sample.kotlinreactive.single

import android.annotation.SuppressLint
import android.support.v4.content.ContextCompat
import com.baculsoft.sample.kotlinreactive.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout

class SingleUI : AnkoComponent<SingleActivity> {

    @SuppressLint("NewApi")
    override fun createView(ui: AnkoContext<SingleActivity>) = with(ui) {
        coordinatorLayout {
            id = R.id.content_single
            backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimary)

            relativeLayout {
                appBarLayout {
                    id = R.id.abl_single
                    backgroundColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                    elevation = dip(4).toFloat()

                    toolbar {
                        id = R.id.toolbar_single
                        setTitleTextColor(ContextCompat.getColor(ctx, R.color.colorPrimary))
                    }.lparams {
                        width = matchParent
                        height = wrapContent
                    }
                }.lparams {
                    alignParentTop()
                    width = matchParent
                    height = wrapContent
                }
            }
        }
    }
}