package com.baculsoft.sample.kotlinreactive.completable

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.baculsoft.sample.kotlinreactive.R
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

class CompletableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CompletableUI().setContentView(this)
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
        val toolbar = find<Toolbar>(R.id.toolbar_completable)
        toolbar.title = resources.getString(R.string.menu_completable)

        setSupportActionBar(toolbar)
    }
}