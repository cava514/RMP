import kotlin.math.sin
import kotlin.math.cos
import kotlin.math.sqrt

fun main(){
    println("y(x)")
    print("Введите x: ")
    val x = readln().toDouble()
    print("Введите параметр a: ")
    val a = readln().toDouble()
    functionYofX(x, a)
}

fun functionYofX(x: Double, a: Double){
    when{
        (x < 0.00) -> {
            println("y(x) = a + x**3")
            println("y(x) = ${a + x * x * x}")
        }
        (x in 0.00..3.00) -> {
            println("y(x) = sin(x) + cos(x)")
            println("y(x) = ${sin(x) + cos(x)}")
        }
        (x in 3.00..5.00) -> {
            println("y(x) = 1/(a-x)")
            println("y(x) = ${1/(a - x)}")
        }
        (x > 5.00) -> {
            println("y(x) = sqrt(x-a)")
            println("y(x) = ${sqrt(x-a)}")
        }
    }
}