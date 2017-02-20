package com.baculsoft.sample.kotlinreactive.flowable

import android.support.v4.content.ContextCompat
import android.view.Gravity
import com.baculsoft.sample.kotlinreactive.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.design.coordinatorLayout

class FlowableUI : AnkoComponent<FlowableActivity> {

    override fun createView(ui: AnkoContext<FlowableActivity>) = with(ui) {
        coordinatorLayout {
            backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimary)

            relativeLayout {
                toolbar {
                    id = R.id.toolbar_flowable
                    backgroundColor = ContextCompat.getColor(ctx, R.color.colorAccent)
                    setNavigationIcon(R.mipmap.ic_arrow_back)
                    setTitleTextColor(ContextCompat.getColor(ctx, R.color.colorPrimary))
                }.lparams {
                    alignParentTop()
                    width = matchParent
                    height = wrapContent
                }

                textView {
                    id = R.id.tv_flowable
                    text = ctx.resources.getString(R.string.text_flowable)
                    textColor = ContextCompat.getColor(ctx, R.color.colorPrimaryDark)
                    textSize = 16f
                    gravity = Gravity.CENTER
                }.lparams {
                    below(R.id.toolbar_flowable)
                    centerInParent()
                    width = matchParent
                    height = wrapContent
                }

                button {
                    id = R.id.btn_flowable
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