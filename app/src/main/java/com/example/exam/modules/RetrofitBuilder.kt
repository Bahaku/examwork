package com.example.exam.modules

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private var service: DataService? = null

    fun getService(): DataService? {
        if (service == null)
            service = buildRetrofit()

        return service
    }

    private fun buildRetrofit(): DataService {
        return Retrofit.Builder()
            .baseUrl("https://gorest.co.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DataService::class.java)
    }
}