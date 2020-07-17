package com.eieimon.carsrent

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

            super.onCreate(savedInstanceState)
            setContentView(R.layout.home_screen)

            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

            val actionBar: ActionBar? = supportActionBar
            if (null != actionBar){
                actionBar.hide()
            }

        val btnStart = findViewById<Button>(R.id.start_button)
        btnStart.setOnClickListener{
            val intent = Intent(this, AccountActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}

