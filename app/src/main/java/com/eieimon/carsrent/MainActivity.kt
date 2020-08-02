package com.eieimon.carsrent

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.eieimon.carsrent.ui.home.HomeFragment
import com.eieimon.carsrent.ui.record.RecordFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        val toolbar: Toolbar = findViewById(R.id.toolbar)
//        setSupportActionBar(toolbar)
//
//        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
//        val navView: NavigationView = findViewById(R.id.nav_view)
//        val navController = findNavController(R.id.nav_host_fragment)
//
//        appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.nav_profile, R.id.nav_share, R.id.nav_about_us
//            ), drawerLayout
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)

//        val bottomNavView: BottomNavigationView = findViewById(R.id.navigation_view)
//        bottomNavView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_search,
                R.id.navigation_record,
                R.id.navigation_account
            )
        )
        val navController = findNavController(R.id.nav_host_fragment)

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


    }
}

//    override fun onBackPressed() {
//
//            val intent = Intent(this, AccountActivity::class.java)
//            startActivity(intent)
//            finish()
//    }


//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment)
//        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
//    }
//    private val mOnNavigationItemSelectedListener =
//        BottomNavigationView.OnNavigationItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.navigation_home -> {
//                    findNavController(R.id.nav_host_fragment).navigate(R.id.navigation_home)
//                }
//                R.id.navigation_search -> {
//                    findNavController(R.id.nav_host_fragment).navigate(R.id.navigation_search)
//                }
//                R.id.navigation_record -> {
//                    findNavController(R.id.nav_host_fragment).navigate(R.id.navigation_record)
//                }
//                R.id.navigation_account -> {
//                    findNavController(R.id.nav_host_fragment).navigate(R.id.navigation_account)
//                }
//            }
//            false
//        }

