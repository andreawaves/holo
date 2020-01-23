package com.example.holoapp.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.holoapp.Presenter.MainPresenter
import com.example.holoapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainPresenter.View{

    var presenter : MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)

        btn_ingresar.setOnClickListener { validar() }
    }

    fun validar() {
        val nombre = et_nombre.text.toString().trim()
        val correo = et_correo.text.toString().trim()

        presenter!!.validar(nombre,correo)
    }

    override fun getContext():AppCompatActivity {
        return this
    }

    override fun sonValidos(respuesta:Boolean) {
        if (respuesta) {
            //val intent = Intent(this, SecondActivity::class.java)
            //startActivity(intent)
        }
    }


}
