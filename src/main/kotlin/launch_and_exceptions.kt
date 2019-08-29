import kotlinx.coroutines.*

// this will launch a coroutine and throw an exception in it

suspend fun throwException() {
    yield()
    throw IllegalArgumentException("this is the message")
}

fun main() {
    val handler = CoroutineExceptionHandler { context, ex ->
        println("Caught: ${context[CoroutineName]} ${ex.message}")
    }

    runBlocking {
        try {
            // runs it on the default dispatcher using the CoroutineExceptionHandler
            val job = launch(Dispatchers.Default + handler + SupervisorJob() + CoroutineName("throwing")) {
                throwException() // exception is not handled here, as it occurred in another coroutine
            }

            job.join()

            // the exception cancels the job
            println("Cancelled: ${job.isCancelled}")
        } catch (ex: Exception) {
            // this will never be reached, as the exception occurred in the coroutine
            // and has to be handled in the CoroutineExceptionHandler instead
            println("EXCEPTION: ${ex.message}")
        }

        println("done")
    }
}
