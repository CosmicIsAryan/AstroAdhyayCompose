package com.example.astroadhyaycompose.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class FormViewModel : ViewModel() {
    private val _formData = MutableStateFlow(FormData())
    val formData: StateFlow<FormData> = _formData

    fun updateFormData(newData: FormData) {
        _formData.value = newData
    }
}

data class FormData(
    val phone: String = "",
)