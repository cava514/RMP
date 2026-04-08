class Student : Human {
    var _group:String?
    override val _getInfo:String
        get() {
            super._getInfo
            return "Группа: ${_group}"
        }
    constructor(name:String, age:UInt, group:String):super(name, age){
        _group = group
    }
    override fun toString(): String {
        return "Имя: ${_name} | Возраст: ${_age} | Группа: ${_group}"
    }
}