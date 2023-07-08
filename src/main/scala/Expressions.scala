enum Expr {
  // object Expr allows name collision avoidance
  // ADTs: Algebraic data types (Number, Sum, Var, Prod)
  case Number(n: Int)
  case Sum(e1: Expr, e2: Expr)
  case Var(name: String)
  case Prod(e1: Expr, e2: Expr)
}

import Expr.*

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
def exprMain(): Unit = {
  val sum: Sum = Sum(Number(2), Prod(Sum(Number(3), Number(1)), Number(2)))
  println(eval(sum))
  println(show(sum))
}
