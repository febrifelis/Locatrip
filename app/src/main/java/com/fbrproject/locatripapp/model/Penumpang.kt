package com.fbrproject.locatripapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Penumpang (
    var nama:String? = "",
    var url:String? = "",
) : Parcelable