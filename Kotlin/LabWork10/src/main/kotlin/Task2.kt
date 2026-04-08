import kotlinx.coroutines.*

suspend fun main() = coroutineScope<Unit> {
    var job = launch() {
        doWorkFile()
    }
    while (true){
        if (readln()=="cancel"){
            job.cancelAndJoin()
            break
        }
    }
}

suspend fun doWorkFile(){
    try {
        for (i in 1..30){
            println("Загрузка файла $i")
            delay(3000)
        }
        println("Все файлы загружены")
    }
    catch (e: CancellationException){
        println("Загрузка отменена")
    }
}