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
    private lateinit var root:View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_lista, container, false)
        mContext = root.context


        var listaNailpolish = ArrayList<Nailpolish>()
        var nailpolish = Nailpolish()
        nailpolish.name = "Andrea"
        listaNailpolish.add(nailpolish)

        var nailpolish1 = Nailpolish()
        nailpolish1.name = "Marjorie"
        listaNailpolish.add(nailpolish1)

        setRecyclerAdapter(listaNailpolish)
        return root
    }


    fun setRecyclerAdapter(listaNailpolish: ArrayList<Nailpolish>){
        val recyclerView: RecyclerView = root.findViewById(R.id.nailpolishs_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(mContext)
        val adapter = NailpolishRecyclerAdapter(mContext, listaNailpolish)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

}
