package com.example.holoapp.Presenter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.holoapp.Model.Nailpolish
import com.example.holoapp.R
import com.example.holoapp.View.DetalleActivity
import kotlinx.android.synthetic.main.item_nailpolish.view.*

class NailpolishRecyclerAdapter: RecyclerView.Adapter<NailpolishRecyclerAdapter.ViewHolder>{

    private var mContext: Context
    private var listaNailpolish: ArrayList<Nailpolish>

    constructor(mContext: Context, listaNailpolish: ArrayList<Nailpolish>) : super() {
        this.mContext = mContext
        this.listaNailpolish = listaNailpolish
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(mContext).inflate(R.layout.item_nailpolish, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listaNailpolish.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val nailpolish = listaNailpolish.get(position)
        holder.item_name.text = nailpolish.name
        holder.item_price.text = nailpolish.price

        Glide.with(mContext)
            .load(nailpolish.photo1)
            .into(holder.item_photo1)

        holder.item_holder.setOnClickListener { irADetalle(nailpolish) }
    }

    fun irADetalle(nailpolish: Nailpolish) {
        val intent = Intent(mContext, DetalleActivity::class.java)
        intent.putExtra("nailpolish",nailpolish)
        mContext.startActivity(intent)
    }

    class ViewHolder
    constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val item_holder = itemView.item_holder
        val item_photo1 = itemView.item_photo1
        val item_name = itemView.item_name
        val item_price = itemView.item_price
    }

}

