package ru.otus.otuskotlin.ads_vehicles.backend.contexts

enum class ContextStatus {
    NONE,
    PENDING,
    SUCCESS,
    FAILURE;

    val isError: Boolean
        get() = this.equals(FAILURE)

    val isProcessed: Boolean
        get() = listOf<ContextStatus>(ContextStatus.SUCCESS, ContextStatus.FAILURE).contains(this)

    val isNew: Boolean
        get() = this.equals(ContextStatus.NONE)
}