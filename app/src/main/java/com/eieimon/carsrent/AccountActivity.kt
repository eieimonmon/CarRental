package com.eieimon.carsrent

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class AccountActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.account_activity)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val actionBar: ActionBar? = supportActionBar
        if (null != actionBar) {
            actionBar.hide()
        }
        val btnLogin= findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val btnforget= findViewById<TextView>(R.id.forgotten_password)
        btnforget.setOnClickListener{
            val intent = Intent(this, ForgetPassword::class.java)
            startActivity(intent)
            finish()
        }

        val btncreate= findViewById<Button>(R.id.btn_create)
        btncreate.setOnClickListener{
            val intent = Intent(this, CreateActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    override fun onBackPressed() {

        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

}