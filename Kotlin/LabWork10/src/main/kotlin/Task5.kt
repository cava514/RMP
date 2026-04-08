import kotlinx.coroutines.*

suspend fun main() = coroutineScope<Unit>{
    var jobThread = launch(context = Dispatchers.IO) {
        doWorkWebAPIServer()
    }
}

suspend fun doWorkWebAPIServer(){
    println()
}