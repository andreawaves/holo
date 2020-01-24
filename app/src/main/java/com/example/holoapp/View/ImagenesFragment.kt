package com.example.holoapp.View


import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.holoapp.Presenter.ImagenAdapter
import com.example.holoapp.Presenter.ImagenesPresenter

import com.example.holoapp.R
import kotlinx.android.synthetic.main.fragment_imagenes.*


class ImagenesFragment : Fragment(), ImagenesPresenter.View{

    private lateinit var root : View
    private lateinit var mContext : Context
    private lateinit var presenter: ImagenesPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        root = inflater.inflate(R.layout.fragment_imagenes, container, false)
        mContext = root.context
        presenter = ImagenesPresenter(this)
        presenter.obtenerListaImagenes()

        return root
    }

    override fun onImagenesDataFinished(listaImagenes: ArrayList<String>) {
        val adapter = ImagenAdapter(mContext, listaImagenes)
        gv_imagenes.adapter = adapter
    }


}
