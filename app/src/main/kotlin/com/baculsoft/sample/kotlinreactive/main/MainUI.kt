package com.baculsoft.sample.kotlinreactive.main

import android.support.v4.content.ContextCompat
import com.baculsoft.sample.kotlinreactive.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainUI : AnkoComponent<MainActivity> {

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        coordinatorLayout {
            backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimary)

            relativeLayout {
                toolbar {
                    id = R.id.toolbar_main
                    backgroundColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                    setTitleTextColor(ContextCompat.getColor(ctx, R.color.colorPrimary))
                }.lparams {
                    alignParentTop()
                    width = matchParent
                    height = wrapContent
                }

                recyclerView {
                    id = R.id.rv_main
                }.lparams { below(R.id.toolbar_main) }
            }
        }
    }
}