package com.eieimon.carsrent.ui.carrent

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eieimon.carsrent.api.CarsApi
import com.eieimon.carsrent.model.PostRent
import com.eieimon.carsrent.model.PostRentResource
import com.eieimon.carsrent.model.Rent
import com.eieimon.carsrent.model.RentResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarRentViewModel: ViewModel() {
    var carRent:MutableLiveData<String> = MutableLiveData()
    fun postCarRent(): LiveData<String> = carRent

    fun loadCarRent(carId:Int,name:String, phone_no:Int, address:String, startDate:String, endDate:String, city_from_id:Int, city_to_id: Int,price:String){
        val CarRent = CarsApi()
        val Call = CarRent.postCarRent(carId,name,phone_no,address,startDate,endDate,city_from_id,city_to_id,price)
        Call.enqueue(object : Callback<PostRentResource> {
            override fun onFailure(call: Call<PostRentResource>, t: Throwable) {
                Log.d("Fail", t.toString())
            }

            override fun onResponse(call: Call<PostRentResource>, response: Response<PostRentResource>) {
                carRent.value = response.body()?.message
                Log.d("Response", response.body()?.message)

            }

        })
    }
    
}