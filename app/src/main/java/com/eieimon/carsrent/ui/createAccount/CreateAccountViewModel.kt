package com.eieimon.carsrent.ui.createAccount

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eieimon.carsrent.api.CarsApi
import com.eieimon.carsrent.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateAccountViewModel :ViewModel(){

    var createAccount : MutableLiveData<String> = MutableLiveData()
    fun postCreateAccount(): LiveData<String> = createAccount

    fun loadCreateAccount(
        username: String,
        email: String,
        password: String,
        phone: Int,
        address: String
    ){
        val Account : CarsApi = CarsApi()
        val Call = Account.postCreateAccount(username, email, password, phone, address)
        Call.enqueue(object : Callback<AdminResource>{
            override fun onFailure(call: Call<AdminResource>, t: Throwable) {
                Log.d("fail", t.toString())
            }

            override fun onResponse(call: Call<AdminResource>, response: Response<AdminResource>) {
                createAccount.value = response.body()?.message
                Log.d("Response", response.body()?.message)
            }

        })
    }
}