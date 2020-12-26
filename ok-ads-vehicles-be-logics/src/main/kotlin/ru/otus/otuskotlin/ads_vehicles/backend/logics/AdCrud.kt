package ru.otus.otuskotlin.ads_vehicles.backend.logics

import ru.otus.otuskotlin.ads_vehicles.backend.contexts.AdContext
import ru.otus.otuskotlin.ads_vehicles.backend.logics.cor.ad.AdCreateChain
import ru.otus.otuskotlin.ads_vehicles.backend.logics.cor.ad.AdGetChain
import ru.otus.otuskotlin.ads_vehicles.backend.logics.cor.ad.AdIndexChain
import ru.otus.otuskotlin.ads_vehicles.backend.logics.cor.ad.AdUpdateChain
import ru.otus.otuskotlin.ads_vehicles.storage.common.repositories.IAdRepository
import ru.otus.otuskotlin.ads_vehicles.storage.common.repositories.IEquipmentRepository

class AdCrud private constructor(
        private val adCreateChain: AdCreateChain,
        private val adUpdateChain: AdUpdateChain,
        private val adIndexChain: AdIndexChain,
        private val adGetChain: AdGetChain
) {
    constructor(
            adRepository: IAdRepository,
            equipmentRepository: IEquipmentRepository
    ) : this(
            adCreateChain = AdCreateChain(
                    adRepository = adRepository,
                    equipmentRepository = equipmentRepository
            ),
            adUpdateChain = AdUpdateChain(
                    adRepository = adRepository,
                    equipmentRepository = equipmentRepository
            ),
            adIndexChain = AdIndexChain(
                    adRepository = adRepository
            ),
            adGetChain = AdGetChain(
                    adRepository = adRepository
            )
    )

    suspend fun create(ctx: AdContext) = this.adCreateChain.exec(ctx)
    suspend fun update(ctx: AdContext) = this.adUpdateChain.exec(ctx)
    suspend fun index(ctx: AdContext) = this.adIndexChain.exec(ctx)
    suspend fun get(ctx: AdContext) = this.adGetChain.exec(ctx)
}