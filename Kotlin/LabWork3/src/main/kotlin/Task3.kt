fun main() {
    print("Введите количество секунд прошедшее с начало суток: ")
    var second = readln().toInt()
    val hour = second / 60 / 60
    val minute = hour * 60
    second = second / 60 / 60
    println("${String.format("%d", hour)}:${String.format("%d", minute)}:${String.format("%d", second)}")
}