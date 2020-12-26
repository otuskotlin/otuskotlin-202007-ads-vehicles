package ru.otus.otuskotlin.ads_vehicles.backend.exceptions

class MakeNotFound(id: String) : RuntimeException("Make ID=$id not found")