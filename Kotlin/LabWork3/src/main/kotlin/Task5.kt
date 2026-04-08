fun main() {
    print("Введите внешний радиус: ")
    val externalRadiuse = readln().toDouble()
    print("Введите внутренний радиус: ")
    val internalRadiuse = readln().toDouble()
    val ring = Math.PI * (externalRadiuse * externalRadiuse - internalRadiuse * internalRadiuse)
    println("Площадь кольца: $ring")
}