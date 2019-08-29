import kotlinx.coroutines.*

// this launches 2 coroutines and runs them on the default Dispatcher to enable
// them to run in parallel in background

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
        launch(Dispatchers.Default) { task1() }
        launch(Dispatchers.Default) { task2() }
        println("called task1 and task2 from ${Thread.currentThread()}")
    }

    println("done")
}
