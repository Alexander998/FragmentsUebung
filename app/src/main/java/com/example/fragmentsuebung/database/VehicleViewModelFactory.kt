package com.example.fragmentsuebung.database

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class VehicleViewModelFactory(private val repository: VehicleRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(VehicleViewModel::class.java)){
            return VehicleViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}