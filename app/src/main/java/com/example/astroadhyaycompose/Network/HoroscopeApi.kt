package com.example.astroadhyaycompose.Network

import com.example.astroadhyaycompose.data.HoroscopeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface HoroscopeApi {
        @GET("/?day=today")
        fun getHoroscope(@Query("sign") sign: String): Call<HoroscopeResponse>

}