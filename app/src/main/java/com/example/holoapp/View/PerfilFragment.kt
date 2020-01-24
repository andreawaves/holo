package com.example.holoapp.View


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_perfil.*
import android.text.method.ScrollingMovementMethod
import android.R
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class PerfilFragment : Fragment() {

    private lateinit var toolbar: ActionBar
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(com.example.holoapp.R.layout.fragment_perfil, container, false)
        val mContext = root.context

        val sharedpreferences = mContext.getSharedPreferences("login", Context.MODE_PRIVATE)
        val tv_nombre:TextView = root.findViewById(com.example.holoapp.R.id.tv_nombre)
        val tv_correo:TextView  = root.findViewById(com.example.holoapp.R.id.tv_correo)

        tv_nombre.text = sharedpreferences.getString("nombre", "")!!
        tv_correo.text = sharedpreferences.getString("correo", "")!!


        toolbar = Objects.requireNonNull((Objects.requireNonNull(activity) as AppCompatActivity).supportActionBar)!!
        return root
    }

    override fun onResume() {
        super.onResume()
        toolbar.setHomeAsUpIndicator(R.drawable.ic_menu_close_clear_cancel)
        toolbar.setDisplayHomeAsUpEnabled(true)

    }

    override fun onStop() {
        super.onStop()
        toolbar.setDisplayHomeAsUpEnabled(false)
    }


}
