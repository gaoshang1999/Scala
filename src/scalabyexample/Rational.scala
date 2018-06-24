package scalabyexample

class Rational(n: Int, d: Int) {
  private def gcd(x: Int, y: Int): Int = {
    if (x == 0) y
    else if (x < 0) gcd(
      x,
      y)
    else if (y < 0) gcd(
      x, y)
    else gcd(y % x, x)
  }
  private val g = gcd(n, d)
  val numer: Int = n / g
  val denom: Int = d / g
  def +(that: Rational) = new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
  def -(that: Rational) = new Rational(numer * that.denom - that.numer * denom, denom * that.denom)
  def *(that: Rational) = new Rational(numer * that.numer, denom * that.denom)
  def /(that: Rational) = new Rational(numer * that.denom, denom * that.numer)

  override def toString =  numer + "/" + denom

  def square = new Rational(numer * numer, denom * denom)
}

object Rational {

  def main(args: Array[String]): Unit = {
    var i = 1
    var x = new Rational(0, 1)
    while (i <= 10) {
      x += new Rational(1, i)
      i += 1
    }
    println(x)

    val r = new Rational(3, 4)
    println(r.square)
  }
}