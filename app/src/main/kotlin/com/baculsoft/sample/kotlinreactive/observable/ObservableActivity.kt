package com.baculsoft.sample.kotlinreactive.observable

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import com.baculsoft.sample.kotlinreactive.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

class ObservableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ObservableUI().setContentView(this)
        setToolbar()
        addListener()
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
        val toolbar = find<Toolbar>(R.id.toolbar_observable)
        toolbar.title = resources.getString(R.string.menu_observable)

        setSupportActionBar(toolbar)
    }

    private fun addListener() {
        val button = find<Button>(R.id.btn_observable)
        val textView = find<TextView>(R.id.tv_observable)
        button.setOnClickListener { view -> doSubscribe(textView) }
    }

    private fun doSubscribe(textView: TextView) {
        Observable.just("Hello Reactive!").observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe({ textView.text = it.toString() }, { it.printStackTrace() })
    }
}