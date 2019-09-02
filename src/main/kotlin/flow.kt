import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    ints(5).map { it * it }.collect { println(it) }
}

// flows are sequential and do not necessarily require any concurrency
fun ints(starting: Int) = flow {
    for (i in starting..20) {
        delay(100)
        emit(i)
    }
}

fun <T,R> Flow<T>.map(transform: (T) -> R) = flow {
    collect { emit(transform(it)) }
}
