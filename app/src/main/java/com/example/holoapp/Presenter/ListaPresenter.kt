package com.example.holoapp.Presenter

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_lista.*

class ListaPresenter(var view: ListaPresenter.View)  {

    var mContext : AppCompatActivity

    init {
        mContext = view.getContext()
    }






    interface View {
        fun getContext(): AppCompatActivity
    }
}