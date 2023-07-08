 val f = new (Int => Int) {
  def apply(x: Int) = x * x
}
 
f.apply(10)