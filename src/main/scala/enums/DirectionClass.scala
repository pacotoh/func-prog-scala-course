package enums

abstract class DirectionClass(val dx: Int, val dy: Int) {
  object DirectionObject {
    val Right = new DirectionClass(1, 0) {}
    val Up = new DirectionClass(0, 1) {}
    val Left = new DirectionClass(-1, 0) {}
    val Down = new DirectionClass(0, -1) {}
  }
}
