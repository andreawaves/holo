package com.example.holoapp.Presenter

import androidx.appcompat.app.AppCompatActivity

class ListaPresenter(var view: ListaPresenter.View)  {





    interface View {
        fun getContext(): AppCompatActivity
    }
}