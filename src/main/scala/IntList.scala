import scala.annotation.tailrec

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

case class Cons[T](head: T, tail: List[T]) extends List[T] {
  def isEmpty: Boolean = false
}

case class Nil[T]() extends List[T] {
  def isEmpty: Boolean = true
  def head: T = throw new NoSuchElementException("Nil.head")
  def tail: List[T] = throw new NoSuchElementException("Nil.tail")
}

@tailrec
def nth[T](xs: List[T], n: Int): T = {
  if n < 0 then throw new IndexOutOfBoundsException()
  else if n == 0 then xs.head
  else
    nth(xs.tail, n-1)
}

@main
def listsMain(): Unit = {
  val myNil: Nil[Float] = new Nil[Float]()
  val myCons: Cons[Float] = new Cons[Float](3.14, myNil)
  val myCons2: Cons[Float] = new Cons[Float](2.72, myCons)

  // Se puede omitir el tipo del Cons en el new
  //val myCons: Cons[Float] = new Cons(3.14, myNil)
  println(myCons)

  println(nth[Int](myCons2.asInstanceOf[List[Int]], 1))

  // Otra forma (directa) de crear Cons en cadena
  println(nth(Cons(1, Cons(2, Cons(3, Nil()))), 1))
}