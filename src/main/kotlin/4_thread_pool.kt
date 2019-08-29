import kotlinx.coroutines.*
import java.util.concurrent.Executors

// this uses a fixed thread pool to launch task1 10 times in it while task2 runs in the main thread

fun main() {
    suspend fun task1() {
        println("start task1 in Thread ${Thread.currentThread()}")
        yield()
        delay(2000)
        println("end task1 in Thread ${Thread.currentThread()}")
    }
    suspend fun task2() {
        println("start task2 in Thread ${Thread.currentThread()}")
        yield()
        println("end task2 in Thread ${Thread.currentThread()}")
    }

    println("start")

    Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()).asCoroutineDispatcher().use { context ->
        runBlocking {
            repeat(10) {
                launch(context) { task1() }
            }

            // default for launch() is to run the given lambda in the current context (main thread)
            launch { task2() }
            println("called task1 and task2 from ${Thread.currentThread()}")
        }
    }

    println("done")
}
