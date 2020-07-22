package com.eieimon.carsrent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.eieimon.carsrent.R.id.nav_fragment
import com.google.android.material.navigation.NavigationView


class AccountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title = "User Account"

//        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
//        setSupportActionBar(toolbar)
//
//        val drawerLayout = view.findViewById<DrawerLayout>(R.id.drawer_layout)
//        val navView = view.findViewById<NavigationView>(R.id.nav_view)
//        val navViewController = findNavController(R.id.nav_fragment)
//
//        val appBarConfiguration = AppBarConfiguration(setOf(
//            R.id.nav_profile, R.id.nav_share, R.id.nav_about_us), drawerLayout)
//        setupActionBarWithNavController(navViewController, appBarConfiguration)
//        navView.setupWithNavController(navViewController)
    }


}