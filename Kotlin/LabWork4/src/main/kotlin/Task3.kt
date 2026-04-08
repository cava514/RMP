fun main() {
    println("Вас приветствует 'Конвертартер валют'")
    while (true) {
        println("Выберите валюту: ")
        println("1. Американский доллар")
        println("2. Евро")
        val n = readln().toInt()
        print("Укажите количество рублей на счёте: ")
        val countRuble = readln().toDouble()
        if(n == 1)
            println("${converterCurrency(n, countRuble)}$")
        else if(n == 2)
            println("${converterCurrency(n, countRuble)}Э")
        else
            println("${converterCurrency(n, countRuble)}R")
    }
}

fun converterCurrency(n: Int, countRuble: Double): Double{
    if (countRuble.isNaN() || countRuble < 0)
        return 0.00
    return when(n){
        1 -> countRuble / 75.92
        2 -> countRuble / 89.06
        else -> countRuble
    }
}