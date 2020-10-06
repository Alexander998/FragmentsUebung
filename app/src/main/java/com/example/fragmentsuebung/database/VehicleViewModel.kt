package com.example.fragmentsuebung.database

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class VehicleViewModel(private val repository: VehicleRepository) : ViewModel(),Observable {

    val vehicles = repository.vehicles
    private var isUpdateOrDelete = false
    private lateinit var vehicleToUpdateOrDelete: Vehicle

    @Bindable
    val inputName = MutableLiveData<String>()

    @Bindable
    val inputType = MutableLiveData<String>()

    @Bindable
    val inputRelease = MutableLiveData<String>()

    @Bindable
    val saveOrUpdateButtonText = MutableLiveData<String>()

    @Bindable
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    init{
        saveOrUpdateButtonText.value="SAVE"
        clearAllOrDeleteButtonText.value="CLEAR"
    }

    fun saveOrUpdate(){
        val name = inputName.value!!
        val type = inputType.value!!
        val release = inputRelease!!
        insert(Vehicle (name, type, release))
        inputName.value = null
        inputRelease.value = null
        inputType.value = null
    }

    fun clearOrDelete(){
        clearAll()
    }

    fun insert(vehicle: Vehicle) = viewModelScope.launch {
            repository.insert(vehicle)
        }

    fun update(vehicle: Vehicle) = viewModelScope.launch {
        repository.update(vehicle)
        }


    fun delete(vehicle: Vehicle) = viewModelScope.launch {
        repository.delete(vehicle)
        }

    fun clearAll() = viewModelScope.launch {
        repository.deleteAll()
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }


}