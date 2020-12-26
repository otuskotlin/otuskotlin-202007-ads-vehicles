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

class AudiStock(): IVehicleStockFixtureDataSet {
    override fun getTree(): Collection<Equipment> {
        val make: Make = make {
            name { "Audi" }
            isoCountryCode { "DE" }
        }

        return this.a4(make)
                .plus(this.a6(make))
    }

    private fun a4(make: Make): Collection<Equipment> {
        val a4: Model = model {
            make { make }
            name { "A4" }
        }

        // generations

        val a4b5: Generation = generation {
            model { a4 }
            name { "B5" }
            yearFrom { 1994 }
            yearTo { 2001 }
        }

        val a4b6: Generation = generation {
            model { a4 }
            name { "B6" }
            yearFrom { 2000 }
            yearTo { 2006 }
        }

        val a4b7: Generation = generation {
            model { a4 }
            name { "B7" }
            yearFrom { 2004 }
            yearTo { 2009 }
        }

        val a4b5p16mt: Equipment = equipment {
            generation { a4b5 }
            name { "1.8 MT" }
            engine { EngineType.PETROL }
            engineLayout { EngineLayout.FRONT_STRAIGHT }
            engineCC { 1781 }
            boost { BoostType.NA }
            cylinderLayout { EngineCylinderLayout.INLINE }
            cylinders { 4 }
            power { 125 }
            gearbox { GearboxType.MANUAL }
            gears { 5 }
            drive { DriveType.FULL_TIME_AWD }
            steeringWheel { SteeringWheel.LEFT }
            chassis { ChassisType.SEDAN }
        }

        val a4b5p28mt: Equipment = equipment {
            generation { a4b5 }
            name { "2.8 MT" }
            engine { EngineType.PETROL }
            engineLayout { EngineLayout.FRONT_STRAIGHT }
            engineCC { 2771 }
            boost { BoostType.NA }
            cylinderLayout { EngineCylinderLayout.V }
            cylinders { 6 }
            power { 193 }
            gearbox { GearboxType.MANUAL }
            gears { 5 }
            drive { DriveType.FULL_TIME_AWD }
            steeringWheel { SteeringWheel.LEFT }
            chassis { ChassisType.WAGON }
        }

        val a4b6p30at: Equipment = equipment {
            generation { a4b6 }
            name { "3.0 AT" }
            engine { EngineType.PETROL }
            engineLayout { EngineLayout.FRONT_STRAIGHT }
            engineCC { 2976 }
            boost { BoostType.NA }
            cylinderLayout { EngineCylinderLayout.V }
            cylinders { 6 }
            power { 220 }
            gearbox { GearboxType.AUTO }
            gears { 5 }
            drive { DriveType.FULL_TIME_AWD }
            steeringWheel { SteeringWheel.LEFT }
            chassis { ChassisType.SEDAN }
        }

        val a4b6p18tmt: Equipment = equipment {
            generation { a4b6 }
            name { "1.8T MT" }
            engine { EngineType.PETROL }
            engineLayout { EngineLayout.FRONT_STRAIGHT }
            engineCC { 1781 }
            boost { BoostType.TURBO }
            cylinderLayout { EngineCylinderLayout.INLINE }
            cylinders { 6 }
            power { 190 }
            gearbox { GearboxType.MANUAL }
            gears { 6 }
            drive { DriveType.FULL_TIME_AWD }
            steeringWheel { SteeringWheel.LEFT }
            chassis { ChassisType.SEDAN }
        }

        val a4b7p20mt: Equipment = equipment {
            generation { a4b7 }
            name { "2.0 MT" }
            engine { EngineType.PETROL }
            engineLayout { EngineLayout.FRONT_STRAIGHT }
            engineCC { 1984 }
            boost { BoostType.TURBO }
            cylinderLayout { EngineCylinderLayout.INLINE }
            cylinders { 4 }
            power { 220 }
            gearbox { GearboxType.MANUAL }
            gears { 6 }
            drive { DriveType.FULL_TIME_AWD }
            steeringWheel { SteeringWheel.LEFT }
            chassis { ChassisType.SEDAN }
        }

        val rs4b7p42mt: Equipment = equipment {
            generation { a4b7 }
            name { "RS4 MT" }
            engine { EngineType.PETROL }
            engineLayout { EngineLayout.FRONT_STRAIGHT }
            engineCC { 4165 }
            boost { BoostType.NA }
            cylinderLayout { EngineCylinderLayout.V }
            cylinders { 8 }
            power { 420 }
            gearbox { GearboxType.MANUAL }
            gears { 6 }
            drive { DriveType.FULL_TIME_AWD }
            steeringWheel { SteeringWheel.LEFT }
            chassis { ChassisType.WAGON }
        }

        return listOf(
                a4b5p16mt,
                a4b5p28mt,
                a4b6p30at,
                a4b6p18tmt,
                a4b7p20mt,
                rs4b7p42mt
        )
    }

    private fun a6(make: Make): Collection<Equipment> {
        val model: Model = model {
            make { make }
            name { "A6" }
        }

        val a6c7: Generation = generation {
            model { model }
            name { "C7" }
            yearFrom { 2011 }
            yearTo { 2018 }
        }

        val a6c8: Generation = generation {
            model { model }
            name { "C8" }
            yearFrom { 2018 }
            yearTo { 2025 }
        }

        val a6c7d30amt = equipment {
            generation { a6c7 }
            name { "3.0 TDI" }
            engine { EngineType.DIESEL }
            engineLayout { EngineLayout.FRONT_STRAIGHT }
            engineCC { 2967 }
            boost { BoostType.TURBO }
            cylinderLayout { EngineCylinderLayout.V }
            cylinders { 6 }
            power { 245 }
            gearbox { GearboxType.ROBOT }
            gears { 7 }
            drive { DriveType.FULL_TIME_AWD }
            steeringWheel { SteeringWheel.LEFT }
            chassis { ChassisType.SEDAN }
        }

        val a6c7p30amt = equipment {
            generation { a6c7 }
            name { "3.0 TFSI" }
            engine { EngineType.PETROL }
            engineLayout { EngineLayout.FRONT_STRAIGHT }
            engineCC { 2995 }
            boost { BoostType.SUPERCHARGER }
            cylinderLayout { EngineCylinderLayout.V }
            cylinders { 6 }
            power { 310 }
            gearbox { GearboxType.ROBOT }
            gears { 7 }
            drive { DriveType.FULL_TIME_AWD }
            steeringWheel { SteeringWheel.LEFT }
            chassis { ChassisType.WAGON }
        }

        val a6c8p30amt = equipment {
            generation { a6c8 }
            name { "Sport 55 TFSI quattro S tronic" }
            engine { EngineType.PETROL }
            engineLayout { EngineLayout.FRONT_STRAIGHT }
            engineCC { 2995 }
            boost { BoostType.TURBO }
            cylinderLayout { EngineCylinderLayout.V }
            cylinders { 6 }
            power { 340 }
            gearbox { GearboxType.ROBOT }
            gears { 7 }
            drive { DriveType.FULL_TIME_AWD }
            steeringWheel { SteeringWheel.LEFT }
            chassis { ChassisType.SEDAN }
        }

        val a6c8h20amt = equipment {
            generation { a6c8 }
            name { "2.0H" }
            engine { EngineType.HYBRID }
            engineLayout { EngineLayout.FRONT_STRAIGHT }
            engineCC { 1984 }
            boost { BoostType.TURBO }
            cylinderLayout { EngineCylinderLayout.INLINE }
            cylinders { 4 }
            power { 367 }
            gearbox { GearboxType.ROBOT }
            gears { 7 }
            drive { DriveType.FULL_TIME_AWD }
            steeringWheel { SteeringWheel.LEFT }
            chassis { ChassisType.SEDAN }
        }

        return listOf(
                a6c7d30amt,
                a6c7p30amt,
                a6c8p30amt,
                a6c8h20amt
        )
    }
}