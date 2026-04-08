fun main() {
    print("Введите СВОЁ имя: ")
    val name = readlnOrNull()
    print("Введите СВОЙ рост(в см.): ")
    val height = readln().toDouble() / 100
    print("Введите СВОЮ массу(вес) в КГ: ")
    val mass = readln().toDouble()
    val iMT = mass / (height * height)
    println("$name, ваш ИМТ=$iMT")
}