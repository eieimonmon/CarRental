package com.eieimon.carsrent.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Car(
    val capacity: String,
    val car_no: String,
    val category: Category,
    val color: String,
    val created_at: String,
    val description: String,
    val driver: Driver,
    val id: Int,
    val image: String,
    val model: String,
    val status: String,
    val updated_at: String
) : Parcelable