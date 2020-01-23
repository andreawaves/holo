package com.example.holoapp.Presenter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.holoapp.View.ImagenesFragment
import com.example.holoapp.View.ListaFragment
import com.example.holoapp.View.PerfilFragment

class PageAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                ListaFragment()
            }
            1 -> ImagenesFragment()
            else -> {
                return PerfilFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Lista"
            1 -> "Imágenes"
            else -> {
                return "Perfil"
            }
        }
    }
}