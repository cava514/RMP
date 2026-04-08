fun main() {
    print("Введите год: ")
    val year = readln().toInt()
    val bool = year % 4 == 0 || year % 100 != 0 || year % 400 == 0
    println(bool)
}