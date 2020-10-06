package com.example.fragmentsuebung.database

import androidx.lifecycle.MutableLiveData
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "vehicle_data_table")
data class Vehicle(

    @PrimaryKey
    @ColumnInfo(name="vehicle_name")
    var name: String,

    @ColumnInfo(name="vehicle_type")
    var type: String,

    @ColumnInfo(name="vehicle_release")
    var release: String
)