import kotlinx.coroutines.*
import kotlinx.coroutines.channels.actor
import kotlin.coroutines.CoroutineContext

// this starts an actor that runs on the default dispatcher and records every message send to it
// when it is closed, it will print all messages and stop

@ObsoleteCoroutinesApi
fun CoroutineScope.printActor(context: CoroutineContext) = actor<String>(context) {
    val messages = mutableListOf<String>()

    for (msg in channel) {
        messages.add(msg)
    }

    println("from thread ${Thread.currentThread()}")
    println(messages.joinToString(", "))
}

@ObsoleteCoroutinesApi
fun main()  = runBlocking<Unit> {
    val actor = printActor(Dispatchers.Default)

    repeat(100) { i ->
        actor.send(i.toString())
    }

    actor.close()
}
