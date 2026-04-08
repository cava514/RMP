import kotlinx.coroutines.*

suspend fun main() = coroutineScope<Unit> {
    try {
        withTimeout(100000) {
            connectDatabase()
        }
    }
    catch (e: TimeoutCancellationException){
        println("Превышено время ожидания")
    }
}

suspend fun connectDatabase(){
    for (i in 1..5){
        println("Попытка подключения к БД")
        delay(3000)
    }
    println("Подключение к БД\nСтатус: Выполнено")
}