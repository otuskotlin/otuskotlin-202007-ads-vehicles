package ru.otus.otuskotlin.ads_vehicles.storage.fixtures

import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Equipment
import ru.otus.otuskotlin.ads_vehicles.storage.common.IVehicleStockFixtureDataSet

class FullStock(): IVehicleStockFixtureDataSet {
    override fun getTree(): Collection<Equipment> {
        return germany()
                .plus(japan())
                .plus(gb())
                .plus(us())
    }

    private fun germany(): Collection<Equipment> {
        return AudiStock().getTree()
                .plus(BmwStock().getTree())
                .plus(VolkswagenStock().getTree())
    }

    private fun japan(): Collection<Equipment> {
        return MazdaStock().getTree()
                .plus(ToyotaStock().getTree())
                .plus(SubaruStock().getTree())
    }

    private fun gb(): Collection<Equipment> {
        return BentleyStock().getTree()
    }

    private fun us(): Collection<Equipment> {
        return listOf()
    }
}