package com.example.holoapp.Presenter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.example.holoapp.R
import kotlinx.android.synthetic.main.item_imagen.view.*

class ImagenAdapter : BaseAdapter {
    var imagenLista = ArrayList<String>()
    var context: Context? = null

    constructor(context: Context, imagenLista: ArrayList<String>) : super() {
        this.context = context
        this.imagenLista = imagenLista
    }

    override fun getCount(): Int {
        return imagenLista.size
    }

    override fun getItem(position: Int): Any {
        return imagenLista[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imagen = this.imagenLista[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var imagenView = inflator.inflate(R.layout.item_imagen, null)

        Glide.with(context!!)
            .load(imagen)
            .into(imagenView.iv_imagen)

        return imagenView
    }
}