import ru.otus.otuskotlin.ads_vehicles.backend.contexts.MakeContext
import ru.otus.otuskotlin.ads_vehicles.backend.logics.MakeCrud
import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.Make
import ru.otus.otuskotlin.ads_vehicles.storage.common.repositories.IMakeRepository
import kotlin.test.Test

class MakeCrudTest {
    @Test
    fun testMakeCrud(): Unit {
        val crud = MakeCrud(FakeMakeRepo())

    }

    class FakeMakeRepo : IMakeRepository {
        override suspend fun get(id: String): Make {
            TODO("Not yet implemented")
        }

        override suspend fun index(filter: MakeContext.Filter): Collection<Make> {
            TODO("Not yet implemented")
        }

        override suspend fun create(make: Make): Make {
            TODO("Not yet implemented")
        }
    }
}