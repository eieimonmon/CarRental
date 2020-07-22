package com.eieimon.carsrent

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.eieimon.carsrent.ui.createAccount.CreateAccountViewModel
import kotlinx.android.synthetic.main.account_activity.*
import kotlinx.android.synthetic.main.create_account.*
import kotlinx.android.synthetic.main.create_account.email
import kotlinx.android.synthetic.main.create_account.password

class CreateAccountActivity : AppCompatActivity(){

    private lateinit var createAccountViewModel: CreateAccountViewModel
    override fun onCreate(savedInstanceState: Bundle?) {

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_account)


        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val actionBar: ActionBar? = supportActionBar
        if (null != actionBar) {
            actionBar.hide()
        }


        val btnCreate = findViewById<Button>(R.id.btnCreate)
        btnCreate.setOnClickListener {

            var username = userName.text.toString()
            var email = email.text.toString()
            var password = password.text.toString()
            var phone = phone.text.toString().toInt()
            var address = address.text.toString()
            Log.d("admin", password.toString())

            if(TextUtils.isEmpty(username) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(phone.toString()) || TextUtils.isEmpty(address) ){

                return@setOnClickListener
            Toast.makeText(applicationContext,"fill data", Toast.LENGTH_LONG).show()
        }else

           if (username != null && email != null && password != null && phone != null && address !=null) {
                createAccountViewModel = CreateAccountViewModel()
                createAccountViewModel.loadCreateAccount(username, email, password, phone,address)
                createAccountViewModel.postCreateAccount().observe(this, Observer {

                    if (it == "Sign In Successfully"){
                        Toast.makeText(applicationContext, it,Toast.LENGTH_LONG).show()
                        var intent = Intent (this, AccountActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        Toast.makeText(applicationContext, it,Toast.LENGTH_LONG).show()
                    }

                })
            }
        }

    }
    override fun onBackPressed() {

        val intent = Intent(this,AccountActivity::class.java)
        startActivity(intent)
        finish()
    }
}

