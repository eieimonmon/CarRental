package com.eieimon.carsrent.ui.city

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eieimon.carsrent.api.CarsApi
import com.eieimon.carsrent.model.City
import com.eieimon.carsrent.model.CityResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CityViewModel:ViewModel() {


       val city: MutableLiveData<CityResource> = MutableLiveData()

        fun getCity(): LiveData<CityResource> = city

        fun loadTCity() {

            val cityApi : CarsApi = CarsApi()
            val Call = cityApi.getCity()

            Call.enqueue(object : Callback<CityResource> {
                override fun onFailure(call: Call<CityResource>, t: Throwable) {
                    Log.d("Result Error>>>>>>", t.toString())
                }

                override fun onResponse(call: Call<CityResource>, response: Response<CityResource>) {
                    response?.isSuccessful.let {
                       city.value = response.body()
                        Log.d("Result township>>>>>>", city.toString())
                        Log.d("Result Response>>>>>>", response.body().toString())

                    }
                }

            })
        }

}