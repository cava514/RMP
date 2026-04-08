package person

//fun main() {
//    val tom: Person = Person()
//
//    println(tom.name)
//    println(tom.age)
//
//    tom.name = "Tom"
//    tom.age = 20
//
//    println(tom.name)
//    println(tom.age)
//
//    tom.sayHello()
//
//    println(tom)
//}

class Person{
    var name: String = "Undefined"
    var age: Int = 18

    fun sayHello(){
        println("Hello, I'm $name")
    }

    override fun toString(): String {
        return "$name, $age"
    }
}

class Cat(_name:String, var type: String = "Манчкин"){
    var name: String
    var age: Int = 0
        get() = field
        set(value) {
            if(value >= 0)
                field = value
        }
    val tag: String
        get() = "Кошка"

    init {
        name = _name
    }

    constructor(_name:String, age:Int): this(_name){
        this.age = age
    }
}

//private
//protected
//public - по умолчанию
//internal - видимость на уровне пакета

data class Container(var number: Int, var content:String)
//toString
//hashCode
//equals
//copy

//final class - запрещает наследование, по умолчанию

open class Animal

class Dog : Animal(){

}

sealed class Shape{
    class Circle: Shape(){

    }
}

abstract class Figure{
    abstract val type: String
    abstract fun area(): Double
}

class Square(var a: Double): Figure(){
    override val type: String
        get() = "Квадрат"

    override fun area(): Double {
        return a*a
    }
}

enum class Screen{
    HOME{
        override fun show() = println("home")
    },
    PROFILE{
        override fun show() = println("profile")
    },
    SETTINGS{
        override fun show() = println("settings")
    };

    abstract fun show()
}

enum class Color(val rgb:Int){
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF)
}

interface Movable{
    var speed: Double
    fun move() = println("Двигаюсь")
}

class  Car: Movable {
    override var speed: Double = 60.0
    override fun move() {
        super<Movable>.move()
        println("Едем на машине")
    }
}

class Human: Movable{
    override var speed: Double = 5.0
}

interface Messenger{
    fun send(message:String)
}

class InstantMessenger(val programName: String) : Messenger{
    override fun send(message: String){
        println("Через $programName отправлено: $message")
    }
}

class SmartPhone(val name: String, m:Messenger) : Messenger by m

fun Int.square(): Int = this * this

val Int.double : Double
    get() = this.toDouble()

class Item{
    val id: Int
    init {
        id = counter++
    }
    companion object{
        var counter = 0
    }
}

fun main(){

    println(5.square())
    println(5.double)

    val max = InstantMessenger("Max")
    val telegram = InstantMessenger("Telegram")
    val vivo = SmartPhone("Vivo x200 pro", telegram)

    vivo.send("Привет, ФСБ")


//    val human = Human()
//    human.move()
//
//    var color: Color = Color.RED
//
//    var screen: Screen = Screen.HOME
//    screen.show()
}