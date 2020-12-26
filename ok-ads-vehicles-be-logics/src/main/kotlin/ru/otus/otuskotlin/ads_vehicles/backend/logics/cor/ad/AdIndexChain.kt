package ru.otus.otuskotlin.ads_vehicles.backend.logics.cor.ad

import ru.otus.otuskotlin.ads_vehicles.backend.GenericError
import ru.otus.otuskotlin.ads_vehicles.backend.contexts.AdContext
import ru.otus.otuskotlin.ads_vehicles.backend.contexts.ContextStatus
import ru.otus.otuskotlin.ads_vehicles.common.cor.IExec
import ru.otus.otuskotlin.ads_vehicles.common.cor.corProcessor
import ru.otus.otuskotlin.ads_vehicles.storage.common.repositories.IAdRepository

class AdIndexChain(
        private val adRepository: IAdRepository
) {
    private val chain: IExec<AdContext> = corProcessor<AdContext> {
        isApplicable { this.status.equals(ContextStatus.NONE) }

        exec { this.status = ContextStatus.PENDING }

        handler {
            isApplicable { this.status.equals(ContextStatus.PENDING) }

            exec {
                try {
                    this.responseIndex = this@AdIndexChain.adRepository.index(this.filter).toMutableList()
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
