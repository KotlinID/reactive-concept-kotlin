package com.baculsoft.sample.kotlinreactive.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.baculsoft.sample.kotlinreactive.R
import com.baculsoft.sample.kotlinreactive.completable.CompletableActivity
import com.baculsoft.sample.kotlinreactive.flowable.FlowableActivity
import com.baculsoft.sample.kotlinreactive.maybe.MaybeActivity
import com.baculsoft.sample.kotlinreactive.observable.ObservableActivity
import com.baculsoft.sample.kotlinreactive.single.SingleActivity
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import org.jetbrains.anko.internals.AnkoInternals

class MainAdapter constructor(val menu: List<String>) : RecyclerView.Adapter<MainAdapter.MainHolder>() {

    companion object {
        val OBSERVABLE = 0
        val FLOWABLE = 1
        val SINGLE = 2
        val COMPLETABLE = 3
        val MAYBE = 4
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainHolder? = MainHolder(MainItemUI().createView(AnkoContext.create(parent!!.context, parent)))

    override fun onBindViewHolder(holder: MainHolder?, position: Int) {
        val name = menu[position]
        holder?.bindView(name)
    }

    override fun getItemCount(): Int = menu.size

    class MainHolder constructor(view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(menu: String) {
            with(menu) {
                val textView = itemView.find<TextView>(R.id.tv_main_menu)
                textView.text = menu

                itemView.setOnClickListener { view ->
                    setMenu(itemView.context, adapterPosition)
                }
            }
        }

        private fun setMenu(context: Context, position: Int) {
            when (position) {
                OBSERVABLE -> {
                    AnkoInternals.internalStartActivity(context, ObservableActivity::class.java, emptyArray())
                }
                FLOWABLE -> {
                    AnkoInternals.internalStartActivity(context, FlowableActivity::class.java, emptyArray())
                }
                SINGLE -> {
                    AnkoInternals.internalStartActivity(context, SingleActivity::class.java, emptyArray())
                }
                COMPLETABLE -> {
                    AnkoInternals.internalStartActivity(context, CompletableActivity::class.java, emptyArray())
                }
                MAYBE -> {
                    AnkoInternals.internalStartActivity(context, MaybeActivity::class.java, emptyArray())
                }
            }
        }
    }
}