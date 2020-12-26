package ru.otus.otuskotlin.ads_vehicles.backend.logics

import ru.otus.otuskotlin.ads_vehicles.backend.contexts.MakeContext
import ru.otus.otuskotlin.ads_vehicles.backend.logics.cor.make.MakeGetChain
import ru.otus.otuskotlin.ads_vehicles.backend.logics.cor.make.MakeIndexChain
import ru.otus.otuskotlin.ads_vehicles.storage.common.repositories.IMakeRepository

class MakeCrud private constructor(
        private val makeGetChain: MakeGetChain,
        private val makeIndexChain: MakeIndexChain
) {
    constructor(makeRepository: IMakeRepository) : this(
            makeGetChain = MakeGetChain(makeRepository),
            makeIndexChain = MakeIndexChain(makeRepository)
    )

    suspend fun get(ctx: MakeContext) = this.makeGetChain.exec(ctx)
    suspend fun index(ctx: MakeContext) = this.makeIndexChain.exec(ctx)
}