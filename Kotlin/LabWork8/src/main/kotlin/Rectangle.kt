class Rectangle : Figure {
    override var _type: String
    var _length:Double = 0.00
    var _width:Double = 0.00
    constructor(type: String){
        _type = type
    }
    override fun square(): Double {
        return _length * _width
    }
    override fun perimeter(): Double {
        return 2.00*(_length+_width)
    }
    override fun getFigure(): String {
        return "Название: ${_type} | Длина: ${_length} | Ширина: ${_width} | Площадь: ${square()} | Периметр: ${perimeter()}"
    }
}