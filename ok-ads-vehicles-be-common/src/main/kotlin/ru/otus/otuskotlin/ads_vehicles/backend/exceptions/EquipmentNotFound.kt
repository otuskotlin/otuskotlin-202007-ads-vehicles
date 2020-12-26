package ru.otus.otuskotlin.ads_vehicles.backend.exceptions

class EquipmentNotFound(id: String) : RuntimeException("Equipment ID=$id not found") {
}