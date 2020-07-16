package com.eieimon.carsrent.ui.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eieimon.carsrent.api.CarsApi
import com.eieimon.carsrent.model.LoginResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel: ViewModel() {

    val login:MutableLiveData<String> = MutableLiveData()

    fun postLogin(): LiveData<String> = login

    fun loadLogin(Email: String, Password: String){
        val Login: CarsApi = CarsApi()
        val Call = Login.postLogin(Email, Password)
        Call.enqueue(object :Callback<LoginResource>{
            override fun onFailure(call: Call<LoginResource>, t: Throwable) {

                Log.d("fail", t.toString())
            }

            override fun onResponse(call: Call<LoginResource>, response: Response<LoginResource>) {

                login.value = response.body()?.message
            }

        })
    }

}