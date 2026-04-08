fun main(){
    print("Введите сторону квадрата(в см): ")
    val side = readln().toDouble()
    println(square(side))
    print("Введите длину прямоугольника(в см): ")
    val length = readln().toDouble()
    print("Введите ширину прямоугольника(в см): ")
    val width = readln().toDouble()
    println(square(length, width))
}
fun square(side:Double):Double{
    return side*side
}
fun square(length: Double, width:Double):Double{
    return length*width
}