import kotlin.jvm.internal.Intrinsics.Kotlin
import kotlin.math.roundToInt
import kotlin.random.Random
import person.Cat as CatClass
import person.Shape

const val d = "Роман"

fun main() {
    println("Hello Word!")

    //var - изменяемое, значение можно присвоить множество раз
    //val - неизменяемое, значение можно присвоить только один раз
    var a = "Роман"
    var b : String
    var c : String = "Роман"

    //Целочисленные
    //Byte -128 ~ 127
    val e : Byte = 1
    //Short -32768 ~ 32767
    val s : Short = 2
    //int -2млрд ~ 2млрд
    val n : Int = 10 //значение по умолчанию
    //Long  -9*10^18 ~ 9*10^18
    val l : Long = 1000L
    //Беззнаковый
    val un : UInt = 10U

    val bin = 0b1010
    val hex = 0xff

    //Вещественные
    //Float
    var f : Float = 3.14F
    //Double
    val d : Double = 3.14
    val de : Double = 23e3 // 23*10^3 = 23000


    //Boolean
    val isTrue : Boolean = true

    val isTrueOrNull : Boolean? = true

    //Char
    val symbol : Char = 'A'
    //String
    val str : String = "QWERT"
    val longText = """
        Привет
        как
        тебя
        зовут
    """.trimIndent()

    //Шаблоны строк
    val message = "$n, qwe, $l, ${1+2}"

    String.format("%.2f", d)
    String.format("%d", n)


    f = d.toFloat()

    "123".toInt()

    var obj : Any = "Qwe"
    obj = 23
    obj = true

    var range = 1 .. 5 step 2
    var range1 = 1 until 5 step 2 // ..<
    var range2 = 5 downTo 1 step 2

    //Вывод на консоль
    print("Hello Word!") //без переноса
    println("Hello Word!") //с переносом строки


    //Ввод с консоли

//    val data = readln().toInt()
//    val data1 = readlnOrNull()

    //+, -, *, /, %, ++, --

    var i = 0
    println(++i)
    println(i++)
    println(i)

    println(3 shl 3) // 11 << 2 = 1100  3 * 2 ^ 3
    println(12 shl 2) // 1100 >> 2 = 11 12 / 2 ^ 2

    //and,or,xor, !, inv / not

    //&&, ||, !

    // in, !in
    var value = 3  in 1 .. 5

    //<, >, ==, !=, <=, >=.

    var doubleVar = Random.nextDouble(1.0, 5.0)

    doubleVar.roundToInt()
    kotlin.math.ceil(doubleVar)
    kotlin.math.floor(doubleVar)
    kotlin.math.round(doubleVar)
    var j = 0

    if (j == 0){

    }
    else if(j > 0){

    }
    else{

    }

    val ter = if (true) {
        //дествия
        println("true")
        1
    }
    else {
        2
    }


    val str1 = when(j){
        0 -> "0"
        1, 2 -> "1"
        in 3 .. 5 -> "3"
        1+5 -> "4"
        else -> ""
    }

    when{
        (j > 0) -> {
            println(1)
            println(2)
        }
        (j == 0) -> println(0)
    }

    loop@while (j  > 0){
        while (i > 0){
            break@loop
        }
    }

    do {

    }while (j > 0)

    for (k in 1..10){
        continue
    }

    for (k in range){

    }


    //Array

    val arr : Array<Int> = arrayOf(1,2,3,4,5)
    val arr1 = arrayOf(1,2,3,4,5)
    var arr2 = intArrayOf(1,2,3,4,5)
    var arr3 = Array<Int>(5, {1}) // 1, 1, 1, 1, 1
    var i1 = 0
    var arr4 = Array<Int>(5, {i1++}) // 0, 1, 2, 3, 4
    var nullArr = arrayOfNulls<Int>(3) // null, null, null
    var randArr = Array<Int>(5, {Random.nextInt(1, 5)})

    println(arr[0])
    arr[0] = 5

    arr.size

    for (item in arr){
        println(item)
    }

    for (k in 0 until arr.size){
        println(arr[k])
    }

    for (k in arr.indices){
        println("$k: ${arr[k]}")
    }

    if (1 in arr){} //элемент есть в массиве
    if (1 !in arr){} //элемент нет в массиве

    arr.reverse() //перевернуть массив
    arr.shuffle() //перемешать массив
    arr.random() //выбрать случайный элемент
    arr.sort() //отсортировать

    var table : Array<Array<Int>> = Array(5, {Array(3, {0})}) //5х2
    table[0][0] = 1

    for (row in table){
        for (cell in row){
            print("$cell\t")
        }
        println()
    }
}