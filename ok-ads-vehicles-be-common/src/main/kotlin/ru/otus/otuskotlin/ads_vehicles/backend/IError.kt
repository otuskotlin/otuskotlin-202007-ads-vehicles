package ru.otus.otuskotlin.ads_vehicles.backend

interface IError {
    val code: String?
    val message: String?
    val originalException: Throwable?
}