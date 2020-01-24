package com.example.holoapp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.holoapp.Model.Nailpolish
import kotlinx.android.synthetic.main.activity_detalle.*
import android.text.method.ScrollingMovementMethod
import android.R



class DetalleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.holoapp.R.layout.activity_detalle)

        val nailpolish = intent.getSerializableExtra("nailpolish") as Nailpolish
        et_name.text = nailpolish.name
        et_price.text = nailpolish.price
        et_description.text = nailpolish.description

        et_description.setMovementMethod(ScrollingMovementMethod())

        Glide.with(this)
            .load(nailpolish.photo2)
            .into(iv_photo2)
    }
}
