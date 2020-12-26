package ru.otus.otuskotlin.ads_vehicles.backend.contexts

import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Model

data class ModelContext(
        var requestModelId: String? = null,
        var filter: Filter = Filter.NONE,
        var responseModel: Model = Model.NONE,
        var responseModelIndex: MutableList<Model> = mutableListOf()
) : AbstractContext() {
    data class Filter(
        val makeId: String? = null,
        val searchString: String? = null
    ) {
        companion object {
            val NONE: Filter = Filter()
        }
    }
}