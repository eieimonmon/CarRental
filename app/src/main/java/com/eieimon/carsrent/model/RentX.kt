package com.eieimon.carsrent.model

data class RentX(
    val car_id: String,
    val city_from_id: String,
    val city_to_id: String,
    val created_at: String,
    val end_date: String,
    val id: Int,
    val price: String,
    val start_date: String,
    val updated_at: String,
    val user_id: Int
)