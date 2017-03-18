package com.baculsoft.sample.kotlinreactive.observable

import android.annotation.SuppressLint
import android.support.v4.content.ContextCompat
import android.view.Gravity
import com.baculsoft.sample.kotlinreactive.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.design.coordinatorLayout

class ObservableUI : AnkoComponent<ObservableActivity> {

    @SuppressLint("NewApi")
    override fun createView(ui: AnkoContext<ObservableActivity>) = with(ui) {
        coordinatorLayout {
            id = R.id.content_observable
            backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimary)

            relativeLayout {
                appBarLayout {
                    id = R.id.abl_observable
                    backgroundColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                    elevation = dip(4).toFloat()

                    toolbar {
                        id = R.id.toolbar_observable
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

                textView {
                    id = R.id.tv_observable
                    text = ctx.resources.getString(R.string.text_observable)
                    textColor = ContextCompat.getColor(ctx, R.color.colorPrimaryDark)
                    textSize = 16f
                    gravity = Gravity.CENTER
                }.lparams {
                    below(R.id.abl_observable)
                    centerInParent()
                    width = matchParent
                    height = wrapContent
                }

                button {
                    id = R.id.btn_observable
                    text = ctx.resources.getString(R.string.btn_subscribe)
                    textColor = ContextCompat.getColor(ctx, R.color.colorPrimaryDark)
                    textSize = 16f
                }.lparams {
                    alignParentBottom()
                    width = matchParent
                    height = wrapContent
                    margin = dip(8)
                }
            }
        }
    }
}