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
import android.content.Intent
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.my_toolbar.view.*
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class PerfilFragment : Fragment() {

    private lateinit var root : View
    private lateinit var mContext : Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(com.example.holoapp.R.layout.fragment_perfil, container, false)
        mContext = root.context

        val sharedpreferences = mContext.getSharedPreferences("login", Context.MODE_PRIVATE)
        val tv_nombre:TextView = root.findViewById(com.example.holoapp.R.id.tv_nombre)
        val tv_correo:TextView  = root.findViewById(com.example.holoapp.R.id.tv_correo)

        tv_nombre.text = sharedpreferences.getString("nombre", "")!!
        tv_correo.text = sharedpreferences.getString("correo", "")!!

        return root
    }

    override fun onResume() {
        val toolbar = activity!!.toolbar
        toolbar.x_icon.visibility = View.VISIBLE
        toolbar.x_icon.setOnClickListener{irALogin()}
        super.onResume()

    }

    override fun onPause() {
        val toolbar = activity!!.toolbar
        toolbar.x_icon.visibility = View.INVISIBLE
        super.onPause()
    }

    fun irALogin() {
        val intent = Intent(mContext, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }


}
