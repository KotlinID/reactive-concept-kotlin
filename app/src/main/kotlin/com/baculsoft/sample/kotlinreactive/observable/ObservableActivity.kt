package com.baculsoft.sample.kotlinreactive.observable

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.baculsoft.sample.kotlinreactive.R
import kotlinx.android.synthetic.main.activity_observable.*

class ObservableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_observable)
        setToolbar()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setToolbar() {
        toolbar_observable.title = resources.getString(R.string.menu_observable)
        setSupportActionBar(toolbar_observable)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}