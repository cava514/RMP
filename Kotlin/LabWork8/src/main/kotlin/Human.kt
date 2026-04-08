open class Human {
    var _name:String?
    var _age:UInt?
    open val _getInfo:String
        get() {
            return "Имя: ${_name} | Возраст: ${_age}"
        }
    constructor(name:String, age:UInt){
        _name = name
        _age = age
    }
    override fun toString(): String {
        return "Имя: ${_name} | Возраст: ${_age}"
    }
}