package com.example.exam.modules

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


data class DataPages(
    val data: List<ItemPages>)

@Parcelize
data class ItemPages (
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("description") val description : String,
    @SerializedName("image") val image : String,
    @SerializedName("price") val price : Double,
    @SerializedName("status") val status : Boolean
):Parcelable