package com.example.astroadhyaycompose.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.astroadhyaycompose.Network.RetrofitInstance
import com.example.astroadhyaycompose.data.HoroscopeResponse
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HoroscopeViewModel : ViewModel() {
    var horoscope: String by mutableStateOf("Loading...")

    init {
        fetchHoroscope("aries")
    }

    private fun fetchHoroscope(sign: String) {
        RetrofitInstance.api.getHoroscope(sign).enqueue(object : Callback<HoroscopeResponse> {
            override fun onResponse(call: Call<HoroscopeResponse>, response: Response<HoroscopeResponse>) {
                if (response.isSuccessful) {
                    horoscope = response.body()?.description ?: "No data"
                } else {
                    horoscope = "Failed to load horoscope"
                }
            }

            override fun onFailure(call: Call<HoroscopeResponse>, t: Throwable) {
                horoscope = "Failed to load horoscope"
            }
        })
    }
}
