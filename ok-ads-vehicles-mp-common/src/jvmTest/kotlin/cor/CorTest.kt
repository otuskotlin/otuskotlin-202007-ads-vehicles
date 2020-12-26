package cor

import kotlinx.coroutines.runBlocking
import ru.otus.otuskotlin.ads_vehicles.common.cor.IExec
import ru.otus.otuskotlin.ads_vehicles.common.cor.corProcessor
import kotlin.test.Test
import kotlin.test.assertEquals

class CorTest {
    @Test
    fun testChain(): Unit {
        val chain: IExec<TestContext> = corProcessor {
            exec { baz = "quux" }
            handler {
                isApplicable { foo.isBlank() }
                exec {
                    foo = "qwerty"
                }
            }
        }

        runBlocking {
            val ctx = TestContext("")
            chain.exec(ctx)
            assertEquals("quux", ctx.baz)
            assertEquals("qwerty", ctx.foo)
        }
    }

    data class TestContext(
            var foo: String = "bar",
            var baz: String = "qux"
    )
}