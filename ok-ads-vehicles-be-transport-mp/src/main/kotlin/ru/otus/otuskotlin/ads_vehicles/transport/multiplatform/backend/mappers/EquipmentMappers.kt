package ru.otus.otuskotlin.ads_vehicles.transport.multiplatform.backend.mappers

import ru.otus.otuskotlin.ads_vehicles.backend.contexts.AbstractContext
import ru.otus.otuskotlin.ads_vehicles.backend.contexts.EquipmentContext
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Equipment
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.enums.*
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpByIdQuery
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpEquipmentIndexQuery
import ru.otus.otuskotlin.ads_vehicles.transport.models.KmpEquipmentIndexResponse
import ru.otus.otuskotlin.ads_vehicles.transport.models.vehicle.KmpEquipment

fun EquipmentContext.setQuery(query: KmpByIdQuery) = this.apply {
    this.requestEquipmentId = query.id
}

fun EquipmentContext.setQuery(query: KmpEquipmentIndexQuery) = this.apply {
    if (query.limit != null || query.offset != null) {
        this.index = AbstractContext.Index(query.limit, query.offset)
    }

    this.filter = query.filter?.let {
        EquipmentContext.Filter(
                generationId = it.generationId,
                searchString = it.searchString
        )
    } ?: EquipmentContext.Filter.NONE
}

fun EquipmentContext.responseItem(): KmpEquipment = this.responseEquipment.kmp()

fun EquipmentContext.responseIndex(): KmpEquipmentIndexResponse = KmpEquipmentIndexResponse(
        data = this.responseIndex.map { it.kmp() },
        limit = this.index?.limit,
        offset = this.index?.offset
)

fun Equipment.kmp() = KmpEquipment(
        id = this.id,
        generationId = this.generation.id,
        name = this.name,
        engineType = this.engineType?.kmpToString(),
        engineLayout = this.engineLayout?.kmpToString(),
        boostType = this.boostType?.kmpToString(),
        engineCC = this.engineCC,
        engineCylinderLayout = this.engineCylinderLayout?.kmpToString(),
        engineCylinders = this.engineCylinders,
        enginePowerHP = this.enginePowerHP,
        gearboxType = this.gearboxType?.kmpToString(),
        gears = this.gears,
        driveType = this.driveType?.kmpToString(),
        steeringWheel = this.steeringWheel?.kmpToString(),
        chassisType = this.chassisType?.kmpToString()
)

fun EngineType.kmpToString(): String = when (this) {
    EngineType.PETROL -> "petrol"
    EngineType.DIESEL -> "diesel"
    EngineType.HYBRID -> "hybrid"
    EngineType.ELECTRIC -> "electric"
}

fun EngineLayout.kmpToString(): String = when (this) {
    EngineLayout.FRONT_STRAIGHT -> "front, straight"
    EngineLayout.FRONT_TRANSVERSED -> "front, transversed"
    EngineLayout.MID_STRAIGHT -> "mid, straight"
    EngineLayout.MID_TRANSVERSED -> "mid, transversed"
    EngineLayout.REAR_STRAIGHT -> "rear, straight"
    EngineLayout.REAR_TRANSVERSED -> "rear, transversed"
}

fun BoostType.kmpToString(): String = when (this) {
    BoostType.NA -> "naturally aspirated"
    BoostType.TURBO -> "turbocharged"
    BoostType.SUPERCHARGER -> "supercharged"
}

fun EngineCylinderLayout.kmpToString(): String = when (this) {
    EngineCylinderLayout.INLINE -> "inline"
    EngineCylinderLayout.V -> "V"
    EngineCylinderLayout.VR -> "VR"
    EngineCylinderLayout.W -> "W"
    EngineCylinderLayout.FLAT -> "flat"
    EngineCylinderLayout.ROTARY -> "rotary"
}

fun GearboxType.kmpToString(): String = when (this) {
    GearboxType.MANUAL -> "manual"
    GearboxType.AUTO -> "automatic"
    GearboxType.ROBOT -> "robotic, single clutch"
    GearboxType.DCT -> "robotic, dual clutch"
    GearboxType.CVT -> "continuously variable transmission"
    GearboxType.DIRECT -> "direct drive"
}

fun DriveType.kmpToString(): String = when (this) {
    DriveType.RWD -> "rear"
    DriveType.FWD -> "front"
    DriveType.FULL_TIME_AWD -> "full-time awd"
    DriveType.PART_TIME_AWD -> "part-time awd"
}

fun SteeringWheel.kmpToString(): String = when (this) {
    SteeringWheel.LEFT -> "left"
    SteeringWheel.RIGHT -> "right"
    SteeringWheel.CENTER -> "center"
}

fun ChassisType.kmpToString(): String = when (this) {
    ChassisType.COUPE -> "coupe"
    ChassisType.SEDAN -> "sedan"
    ChassisType.CONVERTIBLE -> "convertible"
    ChassisType.LIFTBACK -> "lift-back"
    ChassisType.WAGON -> "wagon"
    ChassisType.MINIVAN -> "minivan"
    ChassisType.HATCHBACK_3D -> "hatch-back, 3 doors"
    ChassisType.HATCHBACK_5D -> "hatch-back, 5 doors"
    ChassisType.SUV_3D -> "suv, 3 doors"
    ChassisType.SUV_5D -> "suv, 5 doors"
    ChassisType.VAN -> "van"
    ChassisType.ROADSTER -> "roadster"
}