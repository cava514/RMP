fun main(){
    for (i in 0..9){
        print(" ${i*10} ")
        for (j in 1..9){
            if (i == 0) {
                print(" ${j} ")
            }
            else {
                print(" ${(j + i * 10) * (j + i * 10)} ")
            }
        }
        println()
    }
}