trait Expr

case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Var(name: String) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr


def eval(e: Expr): Int = e match {
  case Number(n) => n
  case Sum(e1, e2) => eval(e1) + eval(e2)
  case Prod(e1, e2) => eval(e1) * eval(e2)
}

def show(e: Expr): String = e match {
  case Number(n) => n.toString
  case Sum(e1, e2) => show(e1) + " + " + show(e2)
  case Var(n) => n
  case Prod(e1, e2) => showP(e1) + " * " + showP(e2)
  // Another way to show values in Sum
  //case Sum(e1, e2) => s"${show(e1)} + ${show(e2)}"
}

def showP(e: Expr): String = e match {
  case e: Sum => s"(${show(e)})"
  case _ => show(e)
}

@main
def expr_main(): Unit = {
  val sum: Sum = Sum(Number(2), Prod(Sum(Number(3), Number(1)), Number(2)))
  println(eval(sum))
  println(show(sum))
}
