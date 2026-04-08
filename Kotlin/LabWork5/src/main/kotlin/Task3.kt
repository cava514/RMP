fun main(){
    println("Калькулятор, но только с делением")
    print("Введите делимое: ")
    var a = readln().toDouble()
    print("Введите делитель: ")
    var b:Double = readln().toDouble()
    while (b == 0.00){
        print("Введите НОРМАЛЬНЫЙ делитель: ")
        b = readln().toDouble()
    }
    print("${a} / ${b} = ${a/b}")
}