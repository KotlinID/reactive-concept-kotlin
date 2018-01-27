package com.baculsoft.sample.kotlinreactive.single

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import com.baculsoft.sample.kotlinreactive.R
import com.baculsoft.sample.kotlinreactive.extensions.getStatusBarHeight
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView

class SingleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SingleUI().setContentView(this)
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
        val toolbar = find<Toolbar>(R.id.toolbar_single)
        toolbar.title = resources.getString(R.string.menu_single)
        toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.bg_arrow_back)
        toolbar.setPadding(0, toolbar.getStatusBarHeight(), 0, 0)

        setSupportActionBar(toolbar)
    }

    private fun addListener() {
        val button = find<Button>(R.id.btn_single)
        val textView = find<TextView>(R.id.tv_single)
        button.setOnClickListener { doSubscribe(textView) }
    }

    private fun doSubscribe(textView: TextView) {
        val todos = arrayListOf("Eat", "Sleep", "Work")
        Single.just(todos).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe({ textView.text = it.joinToString(" , ") { it } }, { it.printStackTrace() })
    }
}