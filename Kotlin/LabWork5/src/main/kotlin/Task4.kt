fun main(){
    println("Магазин 'Шестрёрочка Ашота'")
    print("Введите сумму покупки: ")
    val sumPurchases = readln().toDouble()
    print("Введите сумму оплаты: ")
    var sumPayment : Double = readln().toDouble()
    var sumPayment2 : Double = 0.00
    do {
        sumPayment += sumPayment2
        when {
            (sumPayment == sumPurchases) -> {
                println("Спасибо")
            }

            (sumPayment > sumPurchases) -> {
                println("Возьмите сдачу: ${sumPayment - sumPurchases}")
            }
            (sumPayment < sumPurchases) -> {
                println("Ашота не обманешь!")
                println("Введите недостающую сумму: ${sumPurchases - sumPayment}")
                sumPayment2 = readln().toDouble()
            }
        }
    }
    while (sumPayment < sumPurchases)
}