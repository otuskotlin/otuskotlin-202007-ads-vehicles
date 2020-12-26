package ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory

import org.cache2k.Cache
import org.cache2k.Cache2kBuilder
import org.cache2k.configuration.Cache2kConfiguration
import ru.otus.otuskotlin.ads_vehicles.backend.models.IModel
import java.util.concurrent.TimeUnit
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
fun <D> buildCache(ttl: Duration): Cache<String, D> = Cache2kBuilder.of<String, D>(Cache2kConfiguration<String, D>())
        .expireAfterWrite(ttl.toLongMilliseconds(), TimeUnit.HOURS)
        .suppressExceptions(false)
        .build()

@OptIn(ExperimentalTime::class)
fun <D, M : IModel> buildCache(
        ttl: Duration,
        initObjects: Collection<M>,
        mappingFunc: (M) -> D
): Cache<String, D> = buildCache<D>(ttl)
        .also { cache ->
            initObjects.forEach {
                if (!cache.containsKey(it.id)) {
                    cache.put(it.id, mappingFunc(it))
                }
            }
        }