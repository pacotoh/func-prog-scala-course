import scala.annotation.targetName

abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat
  def +(that: Nat): Nat
  def -(that: Nat): Nat
}

object Zero extends Nat {
  override def isZero: Boolean = true

  // We can leave it as "not implemented"
  override def predecessor: Nat = ???

  override def successor: Nat = Succ(this)
  
  override def +(that: Nat): Nat = that

  override def -(that: Nat): Nat = if that.isZero then this else ???

  override def toString: String = "Zero"
}

class Succ(n: Nat) extends Nat {
  override def isZero: Boolean = false

  override def predecessor: Nat = n

  override def successor: Nat = Succ(this)

  override def +(that: Nat): Nat = Succ(n + that)

  override def -(that: Nat): Nat = if that.isZero then this else n - that.predecessor

  override def toString: String = s"Succ($n)"
}

@main
def mainNums(): Unit = {
  val one = Succ(Zero)
  val two = Succ(Succ(Zero))

  println(one.+(two))

  println(one + two)
}