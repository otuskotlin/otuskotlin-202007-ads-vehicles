package ru.otus.otuskotlin.ads_vehicles.backend.logics.cor.make

import ru.otus.otuskotlin.ads_vehicles.backend.GenericError
import ru.otus.otuskotlin.ads_vehicles.backend.ValidationError
import ru.otus.otuskotlin.ads_vehicles.backend.contexts.ContextStatus
import ru.otus.otuskotlin.ads_vehicles.backend.contexts.MakeContext
import ru.otus.otuskotlin.ads_vehicles.common.cor.IExec
import ru.otus.otuskotlin.ads_vehicles.common.cor.corProcessor
import ru.otus.otuskotlin.ads_vehicles.storage.common.repositories.IMakeRepository

class MakeGetChain(private val repository: IMakeRepository) {
    private val chain: IExec<MakeContext> = corProcessor<MakeContext> {
        isApplicable { this.status.equals(ContextStatus.NONE) }

        exec { this.status = ContextStatus.PENDING }

        exec {
            if (this.requestMakeId == null || this.requestMakeId!!.isBlank()) {
                this.status = ContextStatus.FAILURE
                this.errors.add(ValidationError(message = "Make ID cannot be empty"))
            }
        }

        handler {
            isApplicable { this.status.equals(ContextStatus.PENDING) }

            exec {
                try {
                    this.responseMake = this@MakeGetChain.repository.get(this.requestMakeId!!)
                } catch (e: Throwable) {
                    this.status = ContextStatus.FAILURE
                    this.errors.add(GenericError(message = e.message, originalException = e))
                }
            }
        }
    }

    suspend fun exec(ctx: MakeContext) = this.chain.exec(ctx)
}