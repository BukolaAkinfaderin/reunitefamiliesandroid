package com.reunitefamilies.reunitefamilies.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Children (
        val country_of_origin: String,
        val dob: String,
        val firstname: String,
        val lastname: String,
        val location: String,
        val max_age: Int,
        val min_age: Int,
        val reunite_status: String
): Parcelable