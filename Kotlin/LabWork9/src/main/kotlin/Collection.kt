import java.awt.List
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

fun main(){
    //5.1.1
    var fruits = listOf("Манго", "Банан", "Авокадо")
    //5.1.2
    print("Сколько ещё фруктов вы добавите: ")
    val n = readln().toInt()
    var fruit:String
    for (i in 0..n){
        fruit = readln()
        fruits+=fruit
    }
    println(fruits)
    //5.1.3
    fruits.forEachIndexed{ i, f -> println("${i+1} - ${f}") }
    //5.2.1
    var numbers:ArrayList<Int> = arrayListOf()
    print("Добавьте ещё 5 цифр/чисел: ")
    val number1 = readln().toInt()
    val number2 = readln().toInt()
    val number3 = readln().toInt()
    val number4 = readln().toInt()
    val number5 = readln().toInt()
    numbers.add(number1)
    numbers.add(number2)
    numbers.add(number3)
    numbers.add(number4)
    numbers.add(number5)
    //5.2.2
    //индекс элемента, значение которого равно 100
    numbers.filter{ it == 100 }.forEachIndexed{ i, n-> println("${i}") }
    //сумму элементов коллекции
    println(numbers.reduce{x,y -> x+y})
    //среднее значение элементов коллекции
    println(numbers.reduce{x,y -> x+y} / (numbers.size))
    //информацию, все ли числа больше нуля
    println(numbers.all { it > 0 })
    //все нечетные значения элементов
    numbers.filter{ it % 2== 0 }.forEachIndexed{ i, n-> println("${n}") }
    //5.3.2
//    var country = mapOf(PhoneNumberKit.Builder(this))
    var countryes = mutableMapOf(1 to "RU", 1 to "BY", 3 to "US")
    print("Добавьте ещё 3 страны: ")
    val country1 = readln().toString()
    val country2 = readln().toString()
    val country3 = readln().toString()
    countryes.put(4, country1)
    countryes.put(5, country2)
    countryes.put(6, country3)
    //5.3.3
    for(country in countryes){
        println("${country.key} - ${country.value}")
    }
}