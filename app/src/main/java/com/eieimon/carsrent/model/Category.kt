package com.eieimon.carsrent.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(
    val created_at: String,
    val id: Int,
    val name: String,
    val updated_at: String
) : Parcelable