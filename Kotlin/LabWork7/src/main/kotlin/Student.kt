class Student(_surname: String){
    var surname:String? = _surname
        set(value){
            if (value.orEmpty().length > 1)
                field = value
        }
    var name:String? = "Bill"
        set(value){
            if (value.orEmpty().length > 1)
                field = value
        }
    var group:String? = "Universe"
        set(value){
            if (value.orEmpty().length > 1)
                field = value
        }
    var course:UInt? = 1U
        set(value){
            if (value != null) {
                if (value > 0U && value < 8U)
                    field = value
            }
        }

    val curseInfo
        get() = "Курс : ${course}"

    init {
        this.surname = _surname
    }
    constructor(_surname:String, _name:String, _group:String, _course:UInt):this(_surname){
        name = _name
        group = _group
        course = _course
    }

    fun getStudent(){
        println("Студент ${name} - ${surname} - ${group} - ${course}")
    }
}