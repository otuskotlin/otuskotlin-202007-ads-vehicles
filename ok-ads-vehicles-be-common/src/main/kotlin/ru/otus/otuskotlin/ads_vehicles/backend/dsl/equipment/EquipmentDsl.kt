package ru.otus.otuskotlin.ads_vehicles.backend.dsl.equipment

import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Equipment
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Generation
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.enums.*
import ru.otus.otuskotlin.ads_vehicles.backend.sha1
import java.util.*

@EquipmentDslMarker
class EquipmentDsl {
    private var id: String = ""
    private var generation: Generation = Generation.NONE
    private var name: String = ""
    private var engineType: EngineType? = null
    private var engineLayout: EngineLayout? = null
    private var boostType: BoostType? = null
    private var engineCC: Int? = null
    private var engineCylinderLayout: EngineCylinderLayout? = null
    private var engineCylinders: Int? = null
    private var enginePowerHP: Int? = null
    private var gearboxType: GearboxType? = null
    private var gears: Int? = null
    private var driveType: DriveType? = null
    private var steeringWheel: SteeringWheel? = null
    private var chassisType: ChassisType? = null

    public fun build(): Equipment = Equipment(
            id = this.id.takeIf { it.isNotBlank() } ?: sha1(this.generation.id.plus(this.name)),
            name = this.name,
            generation = this.generation,
            engineType = this.engineType,
            engineLayout = this.engineLayout,
            boostType = this.boostType,
            engineCC = this.engineCC,
            engineCylinderLayout = this.engineCylinderLayout,
            engineCylinders = this.engineCylinders,
            enginePowerHP = this.enginePowerHP,
            gearboxType = this.gearboxType,
            gears = this.gears,
            driveType = this.driveType,
            steeringWheel = this.steeringWheel,
            chassisType = this.chassisType
    )

    public fun id(lambda: () -> String): Unit {
        this.id = lambda()
    }

    public fun generation(lambda: () -> Generation): Unit {
        this.generation = lambda()
    }

    public fun name(lambda: () -> String): Unit {
        this.name = lambda()
    }

    public fun engine(lambda: () -> EngineType): Unit {
        this.engineType = lambda()
    }

    public fun engineLayout(lambda: () -> EngineLayout): Unit {
        this.engineLayout = lambda()
    }

    public fun engineCC(lambda: () -> Int): Unit {
        this.engineCC = lambda()
    }

    public fun boost(lambda: () -> BoostType): Unit {
        this.boostType = lambda()
    }

    public fun cylinderLayout(lambda: () -> EngineCylinderLayout): Unit {
        this.engineCylinderLayout = lambda()
    }

    public fun cylinders(lambda: () -> Int): Unit {
        this.engineCylinders = lambda()
    }

    public fun power(lambda: () -> Int): Unit {
        this.enginePowerHP = lambda()
    }

    public fun gearbox(lambda: () -> GearboxType): Unit {
        this.gearboxType = lambda()
    }

    public fun gears(lambda: () -> Int): Unit {
        this.gears = lambda()
    }

    public fun drive(lambda: () -> DriveType): Unit {
        this.driveType = lambda()
    }

    public fun steeringWheel(lambda: () -> SteeringWheel): Unit {
        this.steeringWheel = lambda()
    }

    public fun chassis(lambda: () -> ChassisType): Unit {
        this.chassisType = lambda()
    }
}

fun equipment(conf: EquipmentDsl.() -> Unit) = EquipmentDsl().apply(conf).build()