import java.text.NumberFormat
import java.util.*

fun main(){
    val str1 = "Строка"
    val str2 = "Строка, но другая"

    println(str1 + str2)
    println("$str1 , $str2")

    println(str1[0])
    println(str1.last())
    println(str2.length)

    println("Строка" == str1)
    println("Строка" > str1)
    println("строка".equals(str1, ignoreCase = true))

    println(str1.lowercase())
    println(str1.uppercase())

    str1.filter { it.isLowerCase() }.let(::println)

    val str3 = "   qwe   "
    println(str3.trim()+"|") // с обоих сторон
    println(str3.trimStart()+"|") // с начала
    println(str3.trimEnd()+"|") // c конца

    println(str2.contains("Строка"))
    println(str2.startsWith("Строка"))
    println(str2.endsWith("другая"))

    val str4 = "банан; яблоко; груша"
    println(str4.split("; "))

    println(str2.replace("но", "авось"))
    println(str2.substring(3,6))

    val regex = "[0-9]+".toRegex()
    regex.findAll("111 qwe 234")
        .map { it.value }
        .toList()
        .let { println(it) }

    println("%d%%".format(75))

    val formatter = NumberFormat
        .getCurrencyInstance(
            Locale.forLanguageTag("ru-ru")
        )

    formatter.format(1000).let { println(it) }
}