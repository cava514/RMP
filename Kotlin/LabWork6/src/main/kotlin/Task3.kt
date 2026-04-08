fun main(){
    println(arithmeticMean(1.0,2.0,3.0))
}
fun arithmeticMean(vararg n:Double):Double{
    var sum = 0.00
    for (i in n){
        sum+=i
    }
    return sum/n.size
}