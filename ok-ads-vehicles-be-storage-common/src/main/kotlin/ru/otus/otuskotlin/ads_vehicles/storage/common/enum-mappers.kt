package ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory

import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.enums.*

fun EngineType.toByte(): Byte = when (this) {
    EngineType.PETROL -> 1.toByte()
    EngineType.DIESEL -> 2.toByte()
    EngineType.HYBRID -> 3.toByte()
    EngineType.ELECTRIC -> 4.toByte()
}

fun EngineType.Companion.of(value: Byte): EngineType = when (value) {
    1.toByte() -> EngineType.PETROL
    2.toByte() -> EngineType.DIESEL
    3.toByte() -> EngineType.HYBRID
    4.toByte() -> EngineType.ELECTRIC
    else -> EngineType.PETROL
}

fun EngineLayout.toByte(): Byte = when (this) {
    EngineLayout.FRONT_STRAIGHT -> 1.toByte()
    EngineLayout.FRONT_TRANSVERSED -> 2.toByte()
    EngineLayout.MID_STRAIGHT -> 3.toByte()
    EngineLayout.MID_TRANSVERSED -> 4.toByte()
    EngineLayout.REAR_STRAIGHT -> 5.toByte()
    EngineLayout.REAR_TRANSVERSED -> 6.toByte()
}

fun EngineLayout.Companion.of(value: Byte): EngineLayout = when (value) {
    1.toByte() -> EngineLayout.FRONT_STRAIGHT
    2.toByte() -> EngineLayout.FRONT_TRANSVERSED
    3.toByte() -> EngineLayout.MID_STRAIGHT
    4.toByte() -> EngineLayout.MID_TRANSVERSED
    5.toByte() -> EngineLayout.REAR_STRAIGHT
    6.toByte() -> EngineLayout.REAR_TRANSVERSED
    else -> EngineLayout.FRONT_STRAIGHT
}

fun BoostType.toByte(): Byte = when (this) {
    BoostType.NA -> 1.toByte()
    BoostType.TURBO -> 2.toByte()
    BoostType.SUPERCHARGER -> 3.toByte()
}

fun BoostType.Companion.of(value: Byte): BoostType = when (value) {
    1.toByte() -> BoostType.NA
    2.toByte() -> BoostType.TURBO
    3.toByte() -> BoostType.SUPERCHARGER
    else -> BoostType.NA
}

fun EngineCylinderLayout.toByte(): Byte = when (this) {
    EngineCylinderLayout.INLINE -> 1.toByte()
    EngineCylinderLayout.V -> 2.toByte()
    EngineCylinderLayout.VR -> 3.toByte()
    EngineCylinderLayout.W -> 4.toByte()
    EngineCylinderLayout.FLAT -> 5.toByte()
    EngineCylinderLayout.ROTARY -> 6.toByte()
}

fun EngineCylinderLayout.Companion.of(value:Byte): EngineCylinderLayout = when (value) {
    1.toByte() -> EngineCylinderLayout.INLINE
    2.toByte() -> EngineCylinderLayout.V
    3.toByte() -> EngineCylinderLayout.VR
    4.toByte() -> EngineCylinderLayout.W
    5.toByte() -> EngineCylinderLayout.FLAT
    6.toByte() -> EngineCylinderLayout.ROTARY
    else -> EngineCylinderLayout.INLINE
}

fun GearboxType.toByte(): Byte = when (this) {
    GearboxType.MANUAL -> 1.toByte()
    GearboxType.AUTO -> 2.toByte()
    GearboxType.ROBOT -> 3.toByte()
    GearboxType.DCT -> 4.toByte()
    GearboxType.CVT -> 5.toByte()
    GearboxType.DIRECT -> 6.toByte()
}

fun GearboxType.Companion.of(value: Byte): GearboxType = when (value) {
    1.toByte() -> GearboxType.MANUAL
    2.toByte() -> GearboxType.AUTO
    3.toByte() -> GearboxType.ROBOT
    4.toByte() -> GearboxType.DCT
    5.toByte() -> GearboxType.CVT
    6.toByte() -> GearboxType.DIRECT
    else -> GearboxType.MANUAL
}

fun DriveType.toByte(): Byte = when (this) {
    DriveType.RWD -> 1.toByte()
    DriveType.FWD -> 2.toByte()
    DriveType.FULL_TIME_AWD -> 3.toByte()
    DriveType.PART_TIME_AWD -> 4.toByte()
}

fun DriveType.Companion.of(value: Byte): DriveType = when (value) {
    1.toByte() -> DriveType.RWD
    2.toByte() -> DriveType.FWD
    3.toByte() -> DriveType.FULL_TIME_AWD
    4.toByte() -> DriveType.PART_TIME_AWD
    else -> DriveType.RWD
}

fun ChassisType.toByte(): Byte = when (this) {
    ChassisType.COUPE -> 1.toByte()
    ChassisType.SEDAN -> 2.toByte()
    ChassisType.CONVERTIBLE -> 3.toByte()
    ChassisType.LIFTBACK -> 4.toByte()
    ChassisType.WAGON -> 5.toByte()
    ChassisType.MINIVAN -> 6.toByte()
    ChassisType.HATCHBACK_3D -> 7.toByte()
    ChassisType.HATCHBACK_5D -> 8.toByte()
    ChassisType.SUV_3D -> 9.toByte()
    ChassisType.SUV_5D -> 10.toByte()
    ChassisType.VAN -> 11.toByte()
    ChassisType.ROADSTER -> 12.toByte()
}

fun ChassisType.Companion.of(value: Byte): ChassisType = when (value) {
    1.toByte() -> ChassisType.COUPE
    2.toByte() -> ChassisType.SEDAN
    3.toByte() -> ChassisType.CONVERTIBLE
    4.toByte() -> ChassisType.LIFTBACK
    5.toByte() -> ChassisType.WAGON
    6.toByte() -> ChassisType.MINIVAN
    7.toByte() -> ChassisType.HATCHBACK_3D
    8.toByte() -> ChassisType.HATCHBACK_5D
    9.toByte() -> ChassisType.SUV_3D
    10.toByte() -> ChassisType.SUV_5D
    11.toByte() -> ChassisType.VAN
    12.toByte() -> ChassisType.ROADSTER
    else -> ChassisType.SEDAN
}

fun SteeringWheel.toByte(): Byte = when (this) {
    SteeringWheel.LEFT -> 1.toByte()
    SteeringWheel.RIGHT -> 2.toByte()
    SteeringWheel.CENTER -> 3.toByte()
}

fun SteeringWheel.Companion.of(value: Byte): SteeringWheel = when (value) {
    1.toByte() -> SteeringWheel.LEFT
    2.toByte() -> SteeringWheel.RIGHT
    3.toByte() -> SteeringWheel.CENTER
    else -> SteeringWheel.LEFT
}