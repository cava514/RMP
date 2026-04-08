fun main(){
    print("Выберите позицию арифмитической прогрессии: ")
    val n = readln().toInt()
    println(arithProgress(n))
    println(arithProgress(3, 1, 2))
}
fun arithProgress(n:Int, a:Int=0, d:Int=1):Int{
    return a+d*(n-1)
}