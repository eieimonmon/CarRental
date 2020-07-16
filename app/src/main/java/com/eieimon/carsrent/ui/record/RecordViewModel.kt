package com.eieimon.carsrent.ui.record

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eieimon.carsrent.api.CarsApi
import com.eieimon.carsrent.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecordViewModel : ViewModel() {

    var loading: MutableLiveData<Boolean> = MutableLiveData()
    var loadError:MutableLiveData<Boolean> = MutableLiveData()

    fun getLoading() : LiveData<Boolean> = loading
    fun getLoadError(): LiveData<Boolean> = loadError

    var carRecord:MutableLiveData<List<Rent>> = MutableLiveData()
    fun getCarRecord():LiveData<List<Rent>> = carRecord

    fun loadCarRecord(){

        loading.value = true
        val CarRecord: CarsApi = CarsApi()
        val Call = CarRecord.getCarRecord()
        Call.enqueue(object : Callback<RentResource>{
            override fun onFailure(call: Call<RentResource>, t: Throwable) {

                loading.value = false
                loadError.value = true
                Log.d("Fail",t.toString())
            }

            override fun onResponse(call: Call<RentResource>, response: Response<RentResource>) {
                carRecord.value = response.body()?.rents
            }

        })
    }
}