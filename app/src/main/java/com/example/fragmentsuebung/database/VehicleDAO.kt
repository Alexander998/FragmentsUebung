package com.example.fragmentsuebung.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface VehicleDAO {
    @Insert
    suspend fun insertVehicle(vehicle : Vehicle) : Long

    @Update
    suspend fun updateVehicle(vehicle : Vehicle): Long

    @Delete
    suspend fun deleteVehicle(vehicle : Vehicle): Long

    @Query("DELETE FROM vehicle_data_table")
    suspend fun deleteAll() : Int

    @Query("SELECT * FROM vehicle_data_table")
    fun getAllVehicles():LiveData<List<Vehicle>>
}