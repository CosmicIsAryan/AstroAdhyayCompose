package com.example.astroadhyaycompose.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: HoroscopeApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://aztro.sameerkumar.website/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HoroscopeApi::class.java)
    }
}