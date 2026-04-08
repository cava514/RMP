fun main() {
    print("Введите первое число: ")
    val a = readln().toInt()
    print("Введите второе число: ")
    val b = readln().toInt()
    println("$a + $b = ${a+b}")
    println("$a - $b = ${a-b}")
    println("$a * $b = ${a*b}")
    println("$a / $b = ${a/b.toDouble()}")
    println("$a % $b = ${a%b}")
}