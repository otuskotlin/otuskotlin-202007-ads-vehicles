package ru.otus.otuskotlin.ads_vehicles.backend.contexts

import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Make
import java.util.*

data class MakeContext(
        var requestMakeId: String? = null,
        var filter: Filter = Filter.NONE,
        var responseMake: Make = Make.NONE,
        var responseMakeIndex: MutableList<Make> = mutableListOf()
) : AbstractContext() {
    data class Filter(
            val isoCountry: String? = null,
            val searchString: String? = null
    ) {
        companion object {
            val NONE: Filter = Filter()
        }
    }
}