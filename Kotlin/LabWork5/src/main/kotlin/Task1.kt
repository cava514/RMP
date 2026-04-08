fun main(){
    println("Вывод температуры по Цельсию и Фаренгейту")
    while(true){
        print("Введите шаг: ")
        var n = readln().toInt()
        println("-------------")
        for (i in 100 downTo -50 step n){
            println("| ${temperatureCelsius(i)} | ${"%.2f".format(temperatureFahrenheit(i))} |")
        }
        println("--------------")
    }
}

fun temperatureCelsius(n:Int):Int{
    return n
}

fun temperatureFahrenheit(n:Int):Double{
    return n*1.8+32
}