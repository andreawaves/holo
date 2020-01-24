package com.example.holoapp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.holoapp.Presenter.PageAdapter
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.my_toolbar.view.*
import androidx.fragment.app.FragmentManager


class DashboardActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.holoapp.R.layout.activity_dashboard)

        setSupportActionBar(toolbar as Toolbar)
        supportActionBar!!.title = null
        toolbar.titulo.text = "Holo App"

        val fragmentAdapter = PageAdapter(supportFragmentManager)
        viewpager_main.adapter = fragmentAdapter
        tabs_main.setupWithViewPager(viewpager_main)
    }

}
