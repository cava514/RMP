package main

import kotlinx.coroutines.*

suspend fun main() = coroutineScope<Unit> {
    var job = launch(context = Dispatchers.IO,
        start = CoroutineStart.LAZY) {
        doWork()
    }
    launch() {
        delay(2000)
        job.cancel()
    }
    println("Начало")
    job.start()
    //job.cancelAndJoin()
    job.join() //ожидаем завершения корутины
    println("Конец")
    //Unit
}

suspend fun doWork(){
    try {
        for (i in 1..5)
        {
            println("$i - ${Thread.currentThread().name}")
            delay(1000)
        }
    }
    catch (e: CancellationException){
        println(e.message)
    }
    finally {
        println("finally")
    }
}