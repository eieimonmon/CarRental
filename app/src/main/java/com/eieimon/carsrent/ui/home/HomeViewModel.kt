package com.eieimon.carsrent.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eieimon.carsrent.api.CarsApi
import com.eieimon.carsrent.model.Car
import com.eieimon.carsrent.model.CarResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

//    private val _text = MutableLiveData<String>().apply {
//        value = "This is home Fragment"
//    }

    var loading: MutableLiveData<Boolean> = MutableLiveData()
    var loadError:MutableLiveData<Boolean> = MutableLiveData()

    fun getLoading() : LiveData<Boolean> = loading
    fun getLoadError(): LiveData<Boolean> = loadError

    var carShow: MutableLiveData<List<Car>> = MutableLiveData()
    fun getCarShow(): LiveData<List<Car>> = carShow

    fun loadCarShow() {

        loading.value = true
        val CarShow: CarsApi = CarsApi()
        val Call = CarShow.getCarShow()
        Call.enqueue(object : Callback<CarResource> {
            override fun onFailure(call: Call<CarResource>, t: Throwable) {

                loading.value = false
                loadError.value = true
            }

            override fun onResponse(call: Call<CarResource>, response: Response<CarResource>) {
                carShow.value = response.body()?.cars


            }

        })
    }

}