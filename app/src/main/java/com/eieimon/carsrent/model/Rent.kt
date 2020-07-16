package com.eieimon.carsrent.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class Rent(
    val car: Car,
    val created_at: Any,
    val end_date: String,
    val id: Int,
    val start_date: String,
    val total_day: Any,
    val price: Any,
    val updated_at: Any,
    val user_id: UserId,
    val city_from: City,
    val city_to: City
)