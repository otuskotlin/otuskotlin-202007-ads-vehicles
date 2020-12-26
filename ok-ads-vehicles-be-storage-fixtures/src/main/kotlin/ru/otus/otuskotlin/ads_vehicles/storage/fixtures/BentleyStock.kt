package ru.otus.otuskotlin.ads_vehicles.storage.fixtures

import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Equipment
import ru.otus.otuskotlin.ads_vehicles.storage.common.IVehicleStockFixtureDataSet

class BentleyStock : IVehicleStockFixtureDataSet {
    override fun getTree(): Collection<Equipment> {
        return listOf()
    }
}