package com.baculsoft.sample.kotlinreactive.main

import android.annotation.SuppressLint
import android.support.v4.content.ContextCompat
import com.baculsoft.sample.kotlinreactive.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainUI : AnkoComponent<MainActivity> {

    @SuppressLint("NewApi")
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        coordinatorLayout {
            id = R.id.content_main
            backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimary)

            relativeLayout {
                appBarLayout {
                    id = R.id.abl_main
                    backgroundColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                    elevation = dip(4).toFloat()

                    toolbar {
                        id = R.id.toolbar_main
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

                recyclerView {
                    id = R.id.rv_main
                }.lparams { below(R.id.abl_main) }
            }
        }
    }
}