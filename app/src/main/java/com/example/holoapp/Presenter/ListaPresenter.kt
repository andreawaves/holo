package com.example.holoapp.Presenter

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide.init
import com.example.holoapp.Model.Nailpolish
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_lista.*

class ListaPresenter(var view: ListaPresenter.View)  {

    var db :  FirebaseFirestore

    init {
        db = FirebaseFirestore.getInstance()
        FirebaseFirestore.setLoggingEnabled(true)
    }

    fun obtenerListaNailpolish() {
        val ref = db.collection("nailpolish")

        ref.get()
            .addOnSuccessListener { documents ->
                var listaNailpolish = ArrayList<Nailpolish>()
                for (document in documents) {
                    var nailpolish = document.toObject(Nailpolish::class.java)
                    nailpolish.id = document.id
                    listaNailpolish.add(nailpolish)
                }
                view.onNailpolishDataFinished(listaNailpolish)
            }
            .addOnFailureListener { exception ->
                Log.w("ERROR FIREBASE", "Error getting documents: ", exception)
            }
    }


    interface View {
        fun onNailpolishDataFinished(listaNailpolish:ArrayList<Nailpolish>)
    }
}