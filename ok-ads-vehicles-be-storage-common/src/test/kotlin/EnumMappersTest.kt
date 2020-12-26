import ru.otus.otuskotlin.ads_vehicles.backend.models.vehicle.enums.EngineType
import ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.of
import ru.otus.otuskotlin.ads_vehicles.backend.repository.inmemory.toByte
import kotlin.test.Test
import kotlin.test.assertEquals

class EnumMappersTest {
    @Test
    public fun testEngineTypeToByte(): Unit {
        val petrol = EngineType.PETROL
        assertEquals(1.toByte(), petrol.toByte())

        val diesel = EngineType.DIESEL
        assertEquals(2.toByte(), diesel.toByte())

        val hybrid = EngineType.HYBRID
        assertEquals(3.toByte(), hybrid.toByte())

        val electric = EngineType.ELECTRIC
        assertEquals(4.toByte(), electric.toByte())
    }

    @Test
    public fun testEngineTypeFromByte(): Unit {
        assertEquals(EngineType.PETROL, EngineType.of(1.toByte()))
        assertEquals(EngineType.DIESEL, EngineType.of(2.toByte()))
        assertEquals(EngineType.HYBRID, EngineType.of(3.toByte()))
        assertEquals(EngineType.ELECTRIC, EngineType.of(4.toByte()))
    }
}