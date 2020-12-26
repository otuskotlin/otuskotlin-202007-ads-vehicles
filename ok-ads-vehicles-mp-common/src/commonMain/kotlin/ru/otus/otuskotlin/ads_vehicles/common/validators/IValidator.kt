package ru.otus.otuskotlin.ads_vehicles.common.validators

interface IValidator<T> {
    public fun validate(arg: T): ValidationResult
}