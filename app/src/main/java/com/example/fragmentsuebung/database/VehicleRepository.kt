package com.example.fragmentsuebung.database

class VehicleRepository(private val dao: VehicleDAO) {

    val vehicles = dao.getAllVehicles()

    suspend fun insert(vehicle: Vehicle) {
        dao.insertVehicle(vehicle)
    }

    suspend fun update(vehicle: Vehicle) {
        dao.updateVehicle(vehicle)
    }

    suspend fun deleteAll(vehicle: Vehicle) {
        dao.deleteVehicle(vehicle)
    }

    suspend fun delete(vehicle: Vehicle) {
        return dao.deleteVehicle((vehicle))
    }

    suspend fun deleteAll(): Int {
        return dao.deleteAll()
    }
}