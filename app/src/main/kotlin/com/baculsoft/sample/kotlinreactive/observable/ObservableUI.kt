package com.baculsoft.sample.kotlinreactive.observable

import android.support.v4.content.ContextCompat
import com.baculsoft.sample.kotlinreactive.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.coordinatorLayout

class ObservableUI : AnkoComponent<ObservableActivity> {

    override fun createView(ui: AnkoContext<ObservableActivity>) = with(ui) {
        coordinatorLayout {
            backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimary)

            relativeLayout {
                toolbar {
                    id = R.id.toolbar_observable
                    backgroundColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                    setNavigationIcon(R.mipmap.ic_arrow_back)
                    setTitleTextColor(ContextCompat.getColor(ctx, R.color.colorPrimary))
                }.lparams {
                    alignParentTop()
                    width = matchParent
                    height = wrapContent
                }
            }
        }
    }
}