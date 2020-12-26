package ru.otus.otuskotlin.ads_vehicles.storage.common

import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Equipment

interface IVehicleStockFixtureDataSet {
    /**
     * Should return a collection that can be represented as the following structure
     *
     * equipment1------generation1-------model1-------make
     *               / |                            /
     * equipment2---   |                           /
     *                /                           /
     * equipment3----                            /
     *                                          /
     * equipment4------generation2-------model2
     *                /               /
     * equipment5----               /
     *                             /
     * equipment6------generation3
     */
    fun getTree(): Collection<Equipment>
}