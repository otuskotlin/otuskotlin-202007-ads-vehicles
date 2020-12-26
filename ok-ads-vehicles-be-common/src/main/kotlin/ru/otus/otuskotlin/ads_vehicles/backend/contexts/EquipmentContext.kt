package ru.otus.otuskotlin.ads_vehicles.backend.contexts

import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Equipment

data class EquipmentContext(
        var requestEquipmentId: String? = null,
        var filter: Filter = Filter.NONE,
        var responseEquipment: Equipment = Equipment.NONE,
        var responseIndex: MutableList<Equipment> = mutableListOf()
) : AbstractContext() {
    data class Filter(
            val generationId: String? = null,
            val searchString: String? = null
    ) {
        companion object {
            val NONE: Filter = Filter()
        }
    }
}