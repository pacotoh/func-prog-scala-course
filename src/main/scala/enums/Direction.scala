package enums

enum Direction(val dx: Int, val dy: Int) {
  case Right extends Direction(1, 0)
  case Left extends Direction(-1, 0)
  case Up extends Direction(0, 1)
  case Down extends Direction(0, -1)
}