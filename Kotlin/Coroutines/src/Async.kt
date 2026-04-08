import kotlinx.coroutines.*

suspend fun main() = coroutineScope {
//    val message1 = async {
//        getMessage()
//    }
//    val message2 = async {
//        getMessage()
//    }
//    val message3 = async {
//        getMessage()
//    }
//    println("message ${message1.await()} ${message2.await()} ${message3.await()}")
    var data = withTimeoutOrNull(1500){
//        repeat(1000){
//            println("прив чо дел")
//            delay(300)
//        }
        delay(1600)
        1
    }
    println(data)
    println("End")
}

suspend fun getMessage(): String{
    delay(500)
    return "Hello"
}