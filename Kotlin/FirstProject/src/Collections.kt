fun main() {
    var numbers = listOf(1,2,3,4,5)

    println(numbers.all { n -> n > 0 })
    println(numbers.any { n -> n == 3 })
    println(numbers.count { n -> n > 3 })
    println(numbers.drop(2).take(2))
    println(numbers.filter { n -> n > 2 })
    numbers.forEach {
        println(it)
    }
    println(numbers.joinToString())

    var doubles = numbers.map { it.toDouble() }

    numbers = numbers + 6 - 1

    println(numbers)

    var num = listOf(1,2,3,4,5)

    println(num.reduce{x,y -> x*y})

    var counter = sequence{
        var i = 0
        while (true) yield(i++)
    }

    println(
        counter.drop(50).take(2).joinToString()
    )
}