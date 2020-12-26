package ru.otus.otuskotlin.ads_vehicles.common.cor

class Handler<T> private constructor(
        private val matcher: CorMatcher<T>,
        private val handler: CorHandler<T>,
        private val errorHandler: CorErrorHandler<T>
) : IExec<T> {
    override suspend fun exec(subject: T) {
        try {
            if (this.matcher(subject)) this.handler(subject)
        } catch (e: Throwable) {
            this.errorHandler(subject, e)
        }
    }

    @CorDslMarker
    class Builder<T> {
        private var matcher: CorMatcher<T> = { true }
        private var handler: CorHandler<T> = {}
        private var errorHandler: CorErrorHandler<T> = { throw it }

        fun isApplicable(block: CorMatcher<T>) {
            this.matcher = block
        }

        fun exec(block: CorHandler<T>) {
            this.handler = block;
        }

        fun onError(block: CorErrorHandler<T>) {
            this.errorHandler = block
        }

        fun build(): Handler<T> {
            return Handler<T>(
                    this.matcher,
                    this.handler,
                    this.errorHandler
            )
        }
    }
}