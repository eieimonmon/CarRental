package com.eieimon.carsrent.ui.cardetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eieimon.carsrent.api.CarsApi
import com.eieimon.carsrent.model.Car
import com.eieimon.carsrent.model.CarResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarDetailInfoViewModel: ViewModel(){

    var carDetail: MutableLiveData<List<Car>> = MutableLiveData()
    fun getCarDetail(): LiveData<List<Car>> = carDetail

    fun loadCarDetail() {

        val CarDetail: CarsApi = CarsApi()
        val Call = CarDetail.getCarDetail()
        Call.enqueue(object : Callback<CarResource> {
            override fun onFailure(call: Call<CarResource>, t: Throwable) {

                Log.d("Fail", t.toString())
            }

            override fun onResponse(call: Call<CarResource>, response: Response<CarResource>) {
                this@CarDetailInfoViewModel.carDetail.value = response.body()?.cars

            }

        })
    }
}