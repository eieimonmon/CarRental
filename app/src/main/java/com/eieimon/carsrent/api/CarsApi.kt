package com.eieimon.carsrent.api

import com.eieimon.carsrent.model.CarResource
import com.eieimon.carsrent.model.CityResource
import com.eieimon.carsrent.model.PostRentResource
import com.eieimon.carsrent.model.RentResource
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CarsApi {
    private val carsInterface: CarsInterface


    companion object{
        const val BASE_URL = "http://car-rental.khaingthinkyi.me/api/setup/"
    }

    init {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        carsInterface = retrofit.create(CarsInterface::class.java)
    }

    fun getCarShow(): Call<CarResource> {
        return carsInterface.getCars()
    }

    fun getCarDetail(): Call<CarResource> {
        return carsInterface.getCars()
    }

    fun postCarRent(carId:Int,name:String, phone_no:Int, address:String, startDate:String, endDate:String, city_from_id:Int, city_to_id: Int,price:String): Call<PostRentResource> {
        return carsInterface.postRent(carId,name,phone_no,address,startDate,endDate,city_from_id,city_to_id,price)
    }

    fun getCarRecord(): Call<RentResource> {
        return carsInterface.getRent()
    }

    fun getCity(): Call<CityResource> {
        return carsInterface.getCity()
    }
}