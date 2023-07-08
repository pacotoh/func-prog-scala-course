package enums

@main
def enumsMain(): Unit = {
  println(Color.Red)
  val direction = Direction.Left
  println(s"${direction.dx}, ${direction.dy}")
}
