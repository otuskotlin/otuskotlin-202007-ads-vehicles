package ru.otus.otuskotlin.ads_vehicles.backend.logics.cor.ad

import ru.otus.otuskotlin.ads_vehicles.backend.GenericError
import ru.otus.otuskotlin.ads_vehicles.backend.ValidationError
import ru.otus.otuskotlin.ads_vehicles.backend.contexts.AdContext
import ru.otus.otuskotlin.ads_vehicles.backend.contexts.ContextStatus
import ru.otus.otuskotlin.ads_vehicles.backend.models.ad.Ad
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Equipment
import ru.otus.otuskotlin.ads_vehicles.common.cor.IExec
import ru.otus.otuskotlin.ads_vehicles.common.cor.corProcessor
import ru.otus.otuskotlin.ads_vehicles.storage.common.repositories.*

class AdUpdateChain(
        private val adRepository: IAdRepository,
        private val equipmentRepository: IEquipmentRepository
) {
    private val chain: IExec<AdContext> = corProcessor<AdContext> {
        isApplicable { this.status.equals(ContextStatus.NONE) }

        exec { this.status = ContextStatus.PENDING }

        exec {
            if (this.requestAd == null || this.requestAd!!.id == null) {
                this.status = ContextStatus.FAILURE
                this.errors.add(ValidationError(message = "Ad ID missing"))
            }

            try {
                this@AdUpdateChain.adRepository.get(this.requestAd!!.id!!)
            } catch (e: Throwable) {
                this.status = ContextStatus.FAILURE
                this.errors.add(ValidationError(message = "Ad not found", originalException = e))
            }
        }

        exec {
            val equipment: Equipment = this@AdUpdateChain.equipmentRepository.get(this.requestAd!!.equipment.id!!)
            if (equipment.generation.id != this.requestAd!!.generation.id
                    || equipment.generation.model.id != this.requestAd!!.model.id
                    || equipment.generation.model.make.id != this.requestAd!!.make.id
            ) {
                this.status = ContextStatus.FAILURE
                this.errors.add(ValidationError(message = "Invalid vehicle"))
            }
        }

        handler {
            isApplicable { this.status.equals(ContextStatus.PENDING) }

            exec {
                try {
                    this.responseAd = this@AdUpdateChain.adRepository.create(this.requestAd!!)
                    this.status = ContextStatus.SUCCESS
                } catch (e: Throwable) {
                    this.status = ContextStatus.FAILURE
                    this.errors.add(GenericError(message = e.message, originalException = e))
                }
            }
        }
    }

    suspend fun exec(ctx: AdContext) = this.chain.exec(ctx)
}