import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

// this launches 2 coroutines and runs them concurrently (on the main thread) but
// uses yield() to yield the current coroutine to others to run

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

    runBlocking {
        launch { task1() }
        launch { task2() }
        println("called task1 and task2 from ${Thread.currentThread()}")
    }

    println("done")
}
