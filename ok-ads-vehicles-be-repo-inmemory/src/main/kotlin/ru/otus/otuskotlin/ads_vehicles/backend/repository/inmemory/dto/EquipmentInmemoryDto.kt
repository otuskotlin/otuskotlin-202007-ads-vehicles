package ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.dto

import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Equipment
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Generation
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.enums.*
import ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.of
import ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.toByte

data class EquipmentInmemoryDto(
        val id: String? = null,
        val generationId: String? = null,
        val name: String? = null,
        val engineType: Byte? = null,
        val engineLayout: Byte? = null,
        val boostType: Byte? = null,
        val engineCC: Int? = null,
        val engineCylinderLayout: Byte? = null,
        val engineCylinders: Int? = null,
        val enginePowerHP: Int? = null,
        val gearboxType: Byte? = null,
        val gears: Int? = null,
        val driveType: Byte? = null,
        val steeringWheel: Byte? = null,
        val chassisType: Byte? = null
) {
    companion object {
        fun of(equipment: Equipment): EquipmentInmemoryDto = of(equipment, equipment.id)
        fun of(equipment: Equipment, id: String?): EquipmentInmemoryDto = EquipmentInmemoryDto(
                id = id,
                generationId = equipment.generation.id,
                name = equipment.name,
                engineType = equipment.engineType?.toByte(),
                engineLayout = equipment.engineLayout?.toByte(),
                boostType = equipment.boostType?.toByte(),
                engineCC = equipment.engineCC,
                engineCylinderLayout = equipment.engineLayout?.toByte(),
                engineCylinders = equipment.engineCylinders,
                enginePowerHP = equipment.enginePowerHP,
                gearboxType = equipment.gearboxType?.toByte(),
                gears = equipment.gears,
                driveType = equipment.driveType?.toByte(),
                steeringWheel = equipment.steeringWheel?.toByte(),
                chassisType = equipment.chassisType?.toByte()
        )
    }

    fun model(generation: Generation): Equipment = Equipment(
            id = this.id,
            generation = generation,
            name = this.name,
            engineType = this.engineType?.let { EngineType.of(it) },
            engineLayout = this.engineLayout?.let { EngineLayout.of(it) },
            boostType = this.boostType?.let { BoostType.of(it) },
            engineCC = this.engineCC,
            engineCylinderLayout = this.engineCylinderLayout?.let { EngineCylinderLayout.of(it) },
            engineCylinders = this.engineCylinders,
            enginePowerHP = this.enginePowerHP,
            gearboxType = this.gearboxType?.let { GearboxType.of(it) },
            gears = this.gears,
            driveType = this.driveType?.let { DriveType.of(it) },
            steeringWheel = this.steeringWheel?.let { SteeringWheel.of(it) },
            chassisType = this.chassisType?.let { ChassisType.of(it) }
    )
}
