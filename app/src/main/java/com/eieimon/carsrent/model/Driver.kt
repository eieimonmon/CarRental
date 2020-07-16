package com.eieimon.carsrent.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Driver(
    val address: String,
    val created_at: String,
    val email: String,
    val id: Int,
    val image: String,
    val name: String,
    val password: String,
    val phone_no: String,
    val updated_at: String
) : Parcelable