package com.example.holoapp.View


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.holoapp.Model.Nailpolish
import com.example.holoapp.Presenter.NailpolishRecyclerAdapter

import com.example.holoapp.R
import kotlinx.android.synthetic.main.fragment_lista.*


class ListaFragment : Fragment() {

    private lateinit var mContext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_lista, container, false)
        mContext = root.context
        return root
    }


    fun setRecyclerAdapter(listaNailpolish: ArrayList<Nailpolish>){
        val recyclerView: RecyclerView = nailpolish_recycler_view
        recyclerView.layoutManager = LinearLayoutManager(mContext)
        val adapter = NailpolishRecyclerAdapter(mContext, listaNailpolish)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

}
