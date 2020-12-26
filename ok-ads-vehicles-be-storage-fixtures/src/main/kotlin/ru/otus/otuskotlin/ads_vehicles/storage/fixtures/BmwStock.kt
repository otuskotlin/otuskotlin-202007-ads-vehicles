package ru.otus.otuskotlin.ads_vehicles.storage.fixtures

import ru.otus.otuskotlin.ads_vehicles.backend.dsl.equipment.equipment
import ru.otus.otuskotlin.ads_vehicles.backend.dsl.generation.generation
import ru.otus.otuskotlin.ads_vehicles.backend.dsl.make.make
import ru.otus.otuskotlin.ads_vehicles.backend.dsl.model.model
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Equipment
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Generation
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Make
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Model
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.enums.*
import ru.otus.otuskotlin.ads_vehicles.storage.common.IVehicleStockFixtureDataSet

class BmwStock() : IVehicleStockFixtureDataSet {
    override fun getTree(): Collection<Equipment> {
        val bmw: Make = make {
            name { "BMW" }
            isoCountryCode { "DE" }
        }

        val _3er: Model = model {
            make { bmw }
            name { "3" }
        }

        val e46: Generation = generation {
            model { _3er }
            name { "e46" }
            yearFrom { 1998 }
            yearTo { 2003 }
        }

        val e92: Generation = generation {
            model { _3er }
            name { "e92" }
            yearFrom { 2005 }
            yearTo { 2010 }
        }

        val f30: Generation = generation {
            model { _3er }
            name { "F30" }
            yearFrom { 0 }
            yearTo { 0 }
        }

        val e46330ci: Equipment = equipment {
            generation { e46 }
            name { "330ci" }
            engine { EngineType.PETROL }
            engineLayout { EngineLayout.FRONT_STRAIGHT }
            engineCC { 2979 }
            boost { BoostType.NA }
            cylinderLayout { EngineCylinderLayout.INLINE }
            cylinders { 6 }
            power { 231 }
            gearbox { GearboxType.AUTO }
            gears { 5 }
            drive { DriveType.RWD }
            steeringWheel { SteeringWheel.LEFT }
            chassis { ChassisType.COUPE }
        }

        val e92335: Equipment = equipment {
            generation { e92 }
            name { "335i" }
            engine { EngineType.PETROL }
            engineLayout { EngineLayout.FRONT_STRAIGHT }
            engineCC { 2979 }
            boost { BoostType.TURBO }
            cylinderLayout { EngineCylinderLayout.INLINE }
            cylinders { 6 }
            power { 306 }
            gearbox { GearboxType.MANUAL }
            gears { 6 }
            drive { DriveType.RWD }
            steeringWheel { SteeringWheel.LEFT }
            chassis { ChassisType.COUPE }
        }

        return listOf(
                e46330ci,
                e92335
        )
    }
}