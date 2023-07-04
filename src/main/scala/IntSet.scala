import scala.annotation.unused

/**
 * Abstract Class IntSet with incl and contains methods.
 * IntSet values of Int type
 */
@unused
abstract class IntSet {
  def incl(x: Int): IntSet

  def contains(x: Int): Boolean

  def union(other: IntSet): IntSet
}

@unused
case class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def incl(x: Int): IntSet = {
    if x < elem then NonEmpty(elem, left.incl(x), right)
    else if x > elem then NonEmpty(elem, left, right.incl(x))
    else this
  }

  def contains(x: Int): Boolean = {
    if x < elem then left.contains(x)
    else if x > elem then right.contains(x)
    else
      true
  }

  def union(other: IntSet): IntSet = {
    left.union(right).union(other).incl(elem)
  }
}

@unused
case class Empty() extends IntSet {
  def incl(x: Int): IntSet = NonEmpty(x, Empty(), Empty())

  def contains(x: Int): Boolean = false

  def union(other: IntSet): IntSet = other
}

@main
def main(): Unit = {
  val empty: Empty = Empty()
  val nonEmpty: NonEmpty = empty.incl(10).asInstanceOf[NonEmpty]
  val nonEmpty3: NonEmpty = empty.incl(12).asInstanceOf[NonEmpty]
  val nonEmpty2: NonEmpty = nonEmpty.union(nonEmpty3).asInstanceOf[NonEmpty]

  println(nonEmpty2)
}