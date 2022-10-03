package com.example.mars1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mars1.network.MarsApi
import com.example.mars1.network.MarsPhotos
import kotlinx.coroutines.launch

class OverviewViewModel  : ViewModel() {


    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _photos = MutableLiveData<List<MarsPhotos>>()
    val photos: LiveData<List<MarsPhotos>> = _photos


    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {
       viewModelScope.launch {
    try {
        _photos.value = MarsApi.retrofitService.getPhotos()
        _status.value = "Success: Mars properties retrieved"

    }catch (e: Exception){
            _status.value = "Failure: ${e.message}"
   }}
    }
}