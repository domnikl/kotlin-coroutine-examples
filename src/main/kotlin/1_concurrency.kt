import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// this launches 2 coroutines and runs them concurrently (but not in parallel)

fun main() {
    fun task1() {
        println("start task1 in Thread ${Thread.currentThread()}")
        println("end task1 in Thread ${Thread.currentThread()}")
    }
    fun task2() {
        println("start task2 in Thread ${Thread.currentThread()}")
        println("end task2 in Thread ${Thread.currentThread()}")
    }

    println("start")

    runBlocking {
        // launch always need a CoroutineScope to run in
        launch { task1() }
        launch { task2() }
        println("called task1 and task2 from ${Thread.currentThread()}")
    }

    println("done")
}
