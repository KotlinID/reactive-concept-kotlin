package com.baculsoft.sample.kotlinreactive.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.baculsoft.sample.kotlinreactive.R
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainUI().setContentView(this)
        setToolbar()
        setAdapter()
    }

    private fun setToolbar() {
        val toolbar = find<Toolbar>(R.id.toolbar_main)
        toolbar.title = title
        setSupportActionBar(toolbar)
    }

    private fun setAdapter() {
        val menu = resources.getStringArray(R.array.types).toList()
        val adapter = MainAdapter(menu)
        val layoutManager = LinearLayoutManager(this)
        val recyclerView = find<RecyclerView>(R.id.rv_main)

        recyclerView.layoutManager = layoutManager
        recyclerView.smoothScrollToPosition(recyclerView.bottom)
        recyclerView.adapter = adapter
    }
}