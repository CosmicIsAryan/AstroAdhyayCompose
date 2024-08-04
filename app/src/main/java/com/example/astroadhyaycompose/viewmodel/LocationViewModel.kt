package com.example.astroadhyaycompose.viewmodel

import android.Manifest
import android.app.Application
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


class LocationViewModel(application: Application) : AndroidViewModel(application) {
    private val fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(application)

    private val _location = MutableLiveData<String>()
    val location: LiveData<String> = _location

    fun fetchLocation() {
        if (ContextCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED) {

            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val locationResult = fusedLocationClient.lastLocation.await()
                    if (locationResult != null) {
                        _location.postValue("Lat: ${locationResult.latitude}, Lng: ${locationResult.longitude}")
                    } else {
                        _location.postValue("Location not found")
                    }
                } catch (e: SecurityException) {
                    _location.postValue("Error: Permission denied")
                } catch (e: Exception) {
                    _location.postValue("Error: ${e.message}")
                }
            }
        } else {
            _location.postValue("Permission not granted")
        }
    }
}