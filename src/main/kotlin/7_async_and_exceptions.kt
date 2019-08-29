import kotlinx.coroutines.*

// this will launch a coroutine with async and throw an exception in it
// contrary to launch, async will receive the exception thrown in the coroutine

suspend fun throwAsyncException(): String {
    yield()
    throw IllegalArgumentException("this is the message")

    @Suppress("UNREACHABLE_CODE")
    return "foobar"
}

fun main() {
    runBlocking {
        try {
            // runs it on the default dispatcher
            val job = async(Dispatchers.Default + SupervisorJob()) {
                throwAsyncException()
            }

            // the exception will bubble up from here
            println(job.await())
        } catch (ex: Exception) {
            println(ex) // will be reached and print the exception
        }

        println("done")
    }
}
