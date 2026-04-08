fun main(){
//    var bob : Student = Student()
//    println(bob.name)
    val willy = Student("Spakler")
    println(willy.surname)
    val tom = Student("Readle", "Tom", "Sliserin", 1U)
    println("Студент ${tom.name} - ${tom.surname} - ${tom.group} - ${tom.course}")
    var students : Array<Student> = arrayOf(Student("Billy"), willy, tom)
    for (i in 0..<students.size){
        if (students[i].name == "Tom")
            students[i].getStudent()
    }
}