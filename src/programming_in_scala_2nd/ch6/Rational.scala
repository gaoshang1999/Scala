package programming_in_scala_2nd.ch6

class Rational(n: Int, d: Int) { // This won’t compile
  require(d != 0)
  private val g = gcd(n.abs, d.abs)
  val numer = n / g
  val denom = d / g
  def this(n: Int) = this(n, 1)
  def add(that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom)

  def +(that: Rational): Rational = this.add(that)
     
  def *(that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)

  override def toString = numer + "/" + denom
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
    
   
}

object Rational {
  implicit def intToRational(x: Int) = new Rational(x)
  
  def main(args: Array[String]): Unit = {
    val a = new Rational(1, 3)
    println(a)
    
    val b = new Rational(1, 4)
    
    println(a + b)
    
    val x = new Rational(2, 3)
    
    println( x * 2)
  }
}