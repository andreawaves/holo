package com.example.holoapp.Presenter

import android.util.Log
import com.example.holoapp.Model.Nailpolish
import com.google.firebase.firestore.FirebaseFirestore

class ImagenesPresenter(var view: ImagenesPresenter.View)  {

    var db : FirebaseFirestore

    init {
        db = FirebaseFirestore.getInstance()
        FirebaseFirestore.setLoggingEnabled(true)
    }

    fun obtenerListaImagenes() {
        val ref = db.collection("nailpolish")

        ref.get()
            .addOnSuccessListener { documents ->
                var listaImagenes = ArrayList<String>()
                for (document in documents) {
                    var nailpolish = document.toObject(Nailpolish::class.java)
                    listaImagenes.add(nailpolish.photo1)
                }
                view.onImagenesDataFinished(listaImagenes)
            }
            .addOnFailureListener { exception ->
                Log.w("ERROR FIREBASE", "Error getting documents: ", exception)
            }
    }


    interface View {
        fun onImagenesDataFinished(listaImagenes:ArrayList<String>)
    }
}