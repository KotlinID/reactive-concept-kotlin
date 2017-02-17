package com.baculsoft.sample.kotlinreactive.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.baculsoft.sample.kotlinreactive.R
import com.baculsoft.sample.kotlinreactive.observable.ObservableActivity
import kotlinx.android.synthetic.main.item_main.view.*
import org.jetbrains.anko.internals.AnkoInternals

class MainAdapter constructor(val menu: List<String>) : RecyclerView.Adapter<MainAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_main, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder?, position: Int) {
        val name = menu[position]
        holder?.bindView(name)
    }

    override fun getItemCount(): Int = menu.size

    class MainHolder constructor(view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(menu: String) {
            with(menu) {
                itemView.tv_main_menu.text = menu
                itemView.setOnClickListener { view ->
                    setMenu(itemView.context, adapterPosition)
                }
            }
        }

        private fun setMenu(context: Context, position: Int) {
            when (position) {
                0 -> {
                    AnkoInternals.internalStartActivity(context, ObservableActivity::class.java, emptyArray())
                }
            }
        }
    }
}