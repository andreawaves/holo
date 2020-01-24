package com.example.holoapp.Presenter

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainPresenter (var view: View) {

    var mContext : AppCompatActivity

    init {
        mContext = view.getContext()
    }

    fun validar(nombre:String, correo:String) {
        if (nombre == "" && correo == ""){
            Toast.makeText(mContext, "Complete los campos", Toast.LENGTH_LONG).show()
        } else {
            if (nombre == ""){
                Toast.makeText(mContext, "Complete su nombre", Toast.LENGTH_LONG).show()
            } else {
                if (correo == "") {
                    Toast.makeText(mContext, "Complete su correo", Toast.LENGTH_LONG).show()
                } else {
                    if (correoValido(correo)) {
                        Toast.makeText(mContext, "¡Ingreso existoso!", Toast.LENGTH_LONG).show()
                        guardarDatos(nombre,correo)
                        view.sonValidos(true)
                    } else {
                        Toast.makeText(mContext, "Correo inválido", Toast.LENGTH_LONG).show()
                        view.sonValidos(false)
                    }
                }
            }
        }
    }

    fun guardarDatos(nombre: String,correo: String) {
        val editor : SharedPreferences.Editor = mContext.getSharedPreferences("login",
            Context.MODE_PRIVATE).edit()
        editor.putString("nombre",nombre)
        editor.putString("correo",correo)
        editor.apply()
    }

    fun correoValido(correo: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()
    }

    interface View {
        fun getContext():AppCompatActivity
        fun sonValidos(respuesta:Boolean)
    }
}