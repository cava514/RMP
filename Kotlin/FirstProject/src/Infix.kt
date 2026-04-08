fun main(){
    val Ольга = Person("Ольга")
    Ольга говорит "Роман Викторович"
}


class Person(val name: String){
    infix fun говорит(words:String){
        println("$name говорит $words")
    }
}