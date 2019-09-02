# Kotlin coroutine examples

It attempts to explain various use-cases around coroutines in simple terms to explain them.

1. [concurrency](src/main/kotlin/concurrency.kt): run multiple coroutines concurrently
1. [yield](src/main/kotlin/yield.kt): using `yield()` to yield dispatcher to other coroutines
1. [default dispatcher](src/main/kotlin/default_dispatcher.kt): using `Dispatchers.Default` to run coroutines in parallel
1. [Thread pool](src/main/kotlin/thread_pool.kt): using a fixed Thread pool for coroutines
1. [async](src/main/kotlin/async.kt): `async()` and `await()`
1. [launch and exceptions](src/main/kotlin/launch_and_exceptions.kt): how to handle exceptions in coroutines
1. [async and exceptions](src/main/kotlin/async_and_exceptions.kt): exceptions in `async()` coroutines
1. [produce](src/main/kotlin/produce.kt): how to produce values and use `ReceiveChannel`
1. [actors](src/main/kotlin/actors.kt): how to use actors in Kotlin
1. [flow](src/main/kotlin/flow.kt): uing `Flow` to build sequential streams of events
