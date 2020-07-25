package com.eieimon.carsrent.api

import com.eieimon.carsrent.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface CarsInterface {
    @GET("car")
    fun getCars(): Call<CarResource>

    @GET("city")
    fun getCity(): Call<CityResource>

    @POST("rent")
    fun postRent(
        @Query("car_id" ) carId:Int,
        @Query("name" ) name:String,
        @Query("phone_no" ) phoneNoId:Int,
        @Query("address" ) address:String,
        @Query("start_date" ) startDate:String,
        @Query("end_date" ) endDate:String,
        @Query("city_from_id" ) cityFromId:Int,
        @Query("city_to_id" ) cityToId:Int
//        @Query("price" ) price:String

    ): Call<PostRentResource>

    @GET("rent")
    fun getRent(): Call<RentResource>

    @POST("check_auth")
    fun postLogin(
        @Query("email") Email: String,
        @Query("password") Password : String
    ): Call<LoginResource>

    @POST("user")
    fun postUser(
        @Query("name") username: String,
        @Query("email") email: String,
        @Query("password") password: String,
        @Query("phone_no") phone: Int,
        @Query("address") address: String
    ): Call<AdminResource>

//    @POST("car")
//    fun postCar(
//        @Query("capacity")
//    ): Call<CarResource>
}