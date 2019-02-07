package com.usaa

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.usaa.model.ChildData
import com.usaa.ui.main.MainFragment
import com.usaa.ui.main.RedditDialogFragment
import com.usass.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    fun showDialog(childData: ChildData?) {
        val newFragment = RedditDialogFragment.newInstance(childData?.selftext)
        newFragment.show(supportFragmentManager, "dialog")
    }

}
