package com.example.fragmentsuebung.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Vehicle::class], version = 1)
abstract class VehicleDatabase : RoomDatabase() {

    abstract val vehicleDAO : VehicleDAO

    companion object{
        @Volatile
        private var INSTANCE : VehicleDatabase? = null
        fun getInstance(context: Context):VehicleDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        VehicleDatabase::class.java,
                        "vehicle_data_table"
                    ).build()
                }
                return instance
            }
        }

    }

}


