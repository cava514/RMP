import java.time.Year

fun main() {
    print("Введите год: ")
    val year = readln().toInt()
    print("Введите месяц: ")
    val month = readln().toInt()
    println("Год високосный?: ${isLeapYear(year)}")
    println("Количество дней в месяце: ${CountDayInMonth(month, year)}")
    println("Сезон: ${isSeason(month)}")
}

fun isLeapYear(year: Int):Boolean{
    if(year < 0)
        return false
    return year % 4 == 0 && year % 100 != 0 || year % 400 == 0
}

fun CountDayInMonth(month: Int, year: Int):Int {
    if (month < 0 && year < 0)
        return 0
    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
        return when (month) {
            4, 6, 9, 10 -> 30
            2 -> 28
            else -> 31
        }
    }
    else{
        return when (month) {
            4, 6, 9, 10 -> 30
            2 -> 29
            else -> 31
        }
    }
}

fun isSeason(month: Int):String{
    if (month < 0)
        return ""
    return when(month){
        12,1,2 -> "Зима"
        in 3..5 -> "Весна"
        in 6..8 -> "Лето"
        in 9..11 -> "Осень"
        else -> "Неизвестный сезон"
    }
}