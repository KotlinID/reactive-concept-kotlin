package com.baculsoft.sample.kotlinreactive.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.baculsoft.sample.kotlinreactive.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setToolbar()
        setAdapter()
    }

    private fun setToolbar() {
        toolbar_main.title = title
        setSupportActionBar(toolbar_main)
    }

    private fun setAdapter() {
        val menu = resources.getStringArray(R.array.types).toList()
        val adapter = MainAdapter(menu)
        val layoutManager = LinearLayoutManager(this)

        rv_main.layoutManager = layoutManager
        rv_main.smoothScrollToPosition(rv_main.bottom)
        rv_main.adapter = adapter
    }
}