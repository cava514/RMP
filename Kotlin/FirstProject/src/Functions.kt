

/*
fun имяФункции(прам1:Тип, парам2:Тип = значение, ...) : ТипВозврата{
    тело функции
    return
}

Unit - аналог void в C#
 */

fun function(param1:Int, param2:Int = 0, param3:Int){

}

fun printLines(vararg lines :String){  // params в C#
    for (line in lines)
        println(line)
}

fun sum (a: Int, b:Int):Int{
    return a+b
}
fun sum (a: Double, b:Double):Double{
    return a+b
}

fun main(){
    val f1 = ::function
    val result = function(1, param3=3)

    fun printData(){
        printLines("1", "2","3","4")
        var arr = arrayOf("1", "2","3","4")
        printLines(*arr)
    }

    printData()

    var message = fun() = println("Hello");

    var hello: ()->Unit = { println() }

    var printMin = { a:Int, b:Int ->
        if(a<b) println(a)
        else println(b)
    }
    println()

    action(1,2,::add)
    action(3,1,::sub)
    action(2,2) { a, b -> a * b }
    //хвостовая лямбда trailing lambda
    action(3,2,selectAction("+"))
    println()
    val counter = createCounter()
    counter()
    counter()
    counter()
}

fun createCounter(): ()->Unit{ //внешняя функция высокого порядка
    var n = 0 //лексикографическое окружение (переменные, параметры)
    fun inner(){ //внутренняя функция
        println(n++) //взаимодействует с окружением
    }
    return ::inner // inner - замыкание
}

fun square(x:Int) = x*x

fun action(a:Int, b:Int, op: (Int, Int)->Int){
    val result = op(a, b)
    println(result)
} // функция высокого порядка

fun add(a:Int, b:Int):Int = a+b
fun sub(a:Int, b:Int):Int = a-b

fun selectAction(operation:String):(Int, Int)-> Int{
    return when(operation){
        "+" -> ::add
        "-" -> ::sub
        "*" -> {a,b->a*b}
        else -> {_,_->0}
    }
} // функция высокого порядка

fun fact(x:UInt):UInt{
    if(x==0U) return 1U
    if(x==1U) return 1U
    return x*fact(x-1U)
}