package ru.otus.otuskotlin.ads_vehicles.backend.contexts

import ru.otus.otuskotlin.ads_vehicles.backend.IError

abstract class AbstractContext(
        open var status: ContextStatus = ContextStatus.NONE,

        open var index: Index? = null,
        open var sorting: Sorting? = null,
        open var errors: MutableList<IError> = mutableListOf()
) {
    data class Index(
            val limit: Int? = null,
            val offset: Int? = null
    )

    data class Sorting(
            val by: String? = null,
            val order: SortingOrder = SortingOrder.DEFAULT
    ) {
        enum class SortingOrder {
            ASC,
            DESC;

            companion object {
                val DEFAULT: SortingOrder = ASC
            }
        }
    }
}