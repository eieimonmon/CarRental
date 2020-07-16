package com.eieimon.carsrent

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.eieimon.carsrent.ui.login.LoginViewModel
import kotlinx.android.synthetic.main.account_activity.*

class AccountActivity: AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.account_activity)
        val sharedPreferences: SharedPreferences = this.getSharedPreferences("MyLogin", Context.MODE_PRIVATE)


        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val actionBar: ActionBar? = supportActionBar
        if (null != actionBar) {
            actionBar.hide()
        }

        val btnLogin= findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener{

            var loginemail = email.text.toString()
            var loginpassword = password.text.toString()
            Log.d("email",email.toString())

             if (TextUtils.isEmpty(loginemail) || TextUtils.isEmpty(loginpassword)){
                 if (TextUtils.isEmpty(loginemail) ){
                     email.setError("Email is required")
                     return@setOnClickListener
                 }
                 else {
                     password.setError("Password is required")
                     return@setOnClickListener
                 }

            }else if (loginemail != null && loginpassword !=null){
                loginViewModel = LoginViewModel()
                 loginViewModel.loadLogin(Email = String() , Password = String())
                 loginViewModel.postLogin().observe(this, Observer {

                     val editor:SharedPreferences.Editor =  sharedPreferences.edit()
                     editor.putString("email",loginemail)
                     editor.putString("password",loginpassword)
                     editor.apply()
                     editor.commit()

                 })
                 val intent = Intent(this, MainActivity::class.java)
                 startActivity(intent)
                 finish()

            }
        }


    }
    override fun onBackPressed() {

        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }


}