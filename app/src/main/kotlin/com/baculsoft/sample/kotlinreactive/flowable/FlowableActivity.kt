package com.baculsoft.sample.kotlinreactive.flowable

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import com.baculsoft.sample.kotlinreactive.R
import com.baculsoft.sample.kotlinreactive.ext.statusBarHeight
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

class FlowableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FlowableUI().setContentView(this)
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
        val toolbar = find<Toolbar>(R.id.toolbar_flowable)
        toolbar.title = resources.getString(R.string.menu_flowable)
        toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.bg_arrow_back)
        toolbar.setPadding(0, toolbar.statusBarHeight, 0, 0)

        setSupportActionBar(toolbar)
    }

    private fun addListener() {
        val button = find<Button>(R.id.btn_flowable)
        val textView = find<TextView>(R.id.tv_flowable)
        button.setOnClickListener { doSubscribe(textView) }
    }

    private fun doSubscribe(textView: TextView) {
        Flowable.just(1, 2, 3, 4, 5).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).reduce(50) { t1, t2 -> t1 + t2 }.subscribe({ textView.text = it.toString() }, { it.printStackTrace() })
    }
}