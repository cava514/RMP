package scope

data class Person(val name:String, var email:String?)

fun main() {
    //let
    "hello".let{ println(it) }

    val num = readln().toIntOrNull()

    num?.let { println(it) }

    //with
    val tom = Person("Tom", null)

    var email = with(tom){
        if (email==null)
            email = "default@mail.ru"
        email
    }

    //run
    var email1 = tom.run{
        if (email==null)
            email = "default@mail.ru"
        email
    }

    //apply
    val bob = Employee()
    bob.name("Боб")
        .age(18)
        .company("АКТ")
        .apply { age = 19 }

    //also
    bob.also { it.age = 20 }

    //обработка исключений

    try {
        throw ArithmeticException("Не дели на ноль")
        //код с исключениями
    }
    catch (e:ArithmeticException){
        println(e.localizedMessage)
    }
    catch (e:Exception){
        println(e.localizedMessage)
    }
    finally {
        //постобработка
    }

    var data = try { readln().toInt() } catch (e:Exception){ null }
}

data class Employee(var name: String = "",
                    var age:Int = 0,
                    var company: String = ""){
    fun age(_age:Int):Employee = apply { age=_age }
    fun name(_name:String):Employee = apply { name = _name }
    fun company(_company:String):Employee = apply { company = _company }
}