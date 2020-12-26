package ru.otus.otuskotlin.ads_vehicles.common.cor

class Processor<T> private constructor(
        private val matcher: CorMatcher<T>,
        private val handlers: Collection<IExec<T>>,
        private val errorHandler: CorErrorHandler<T>
): IExec<T> {
    override suspend fun exec(subject: T): Unit {
        try {
            if (this.matcher(subject)) this.handlers.forEach { it.exec(subject) }
        } catch (e: Throwable) {
            this.errorHandler(subject, e)
        }
    }

    @CorDslMarker
    class Builder<T> {
        private var matcher: CorMatcher<T> = { true }
        private var handlers: MutableList<IExec<T>> = mutableListOf()
        private var errorHandler: CorErrorHandler<T> = { throw it }

        fun isApplicable(block: CorMatcher<T>) {
            this.matcher = block
        }

        fun exec(handler: IExec<T>) = this.handlers.add(handler)
        fun exec(block: CorHandler<T>) {
            this.handlers.add(
                    corHandler<T> { exec(block) }
            )
        }

        fun handler(block: Handler.Builder<T>.() -> Unit) = this.handlers.add(corHandler(block))

        fun build(): Processor<T> {
            return Processor<T>(
                    matcher = matcher,
                    handlers = handlers,
                    errorHandler = errorHandler
            )
        }
    }
}