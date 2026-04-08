import kotlinx.coroutines.*

suspend fun main() = coroutineScope<Unit>{
    var jobLambs = launch() {
        doWorkLamb()
    }
    var jobCats = launch() {
        doWorkCats()
    }
    println("${Thread.currentThread().name}")
}

suspend fun doWorkLamb(){
    for (i in 1..500){
        println("$i овечка ${Thread.currentThread().name}")

    }
    delay(1000)
    for (i in 501..1000){
        println("$i овечка ${Thread.currentThread().name}")
    }
}

suspend fun doWorkCats(){
    for (i in 1..500){
        println("$i котики ${Thread.currentThread().name}")
        delay(10)
    }
}