package com.example.exam.modules

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DataService {
    @GET("public-api/products")
    fun getPages(
        @Query("page") pages: String
    ): Call<DataPages>
}