trait Expr {
  def isNumber: Boolean
  def isSum: Boolean
  def numValue: Int
  def leftOp: Expr
  def rightOp: Expr
}

class Number(n: Int) extends Expr {
  override def isNumber: Boolean = true

  override def isSum: Boolean = false

  override def numValue: Int = n

  override def leftOp: Expr = throw Error("Number.left")

  override def rightOp: Expr = throw Error("Number.right")
}

class Sum(e1: Expr, e2: Expr) extends Expr {
  override def isNumber: Boolean = false

  override def isSum: Boolean = true

  override def numValue: Int = throw Error("Sum.numValue")

  override def leftOp: Expr = e1

  override def rightOp: Expr = e2
}