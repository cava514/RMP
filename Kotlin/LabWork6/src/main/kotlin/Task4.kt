import kotlin.math.pow

fun main(){
    print("Введите сумму вклада: ")
    val sum = readln().toDouble()
    print("Введите процент который вы хотите во вкладе: ")
    val percent = readln().toDouble()
    print("Введите срок вклада(в годах P.S. НЕ В ВЕКАХ): ")
    val year = readln().toInt()
    print("По какому проценту вы хотите оформить вклад: ")
    val str = readln()
    val calculator = silence(str)
    println("${calculator(sum, percent, year)} сумма на вкладе через $year лет")
}
fun silence(str: String):(Double, Double, Int)->Double {
    return when (str) {
        "Простой" -> { s, r, n -> s*(1+r/100*n)}
        "Сложный" -> { s, r, n -> s*(1+r/100).pow(n)}
        else -> { _, _, _ -> 0.00}
    }
}