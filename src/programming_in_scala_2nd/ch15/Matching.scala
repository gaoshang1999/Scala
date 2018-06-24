package programming_in_scala_2nd.ch15

object Matching {
  def describe(expr: Any) =
    expr match {
      case 0             => "zero"
      case somethingElse => "not zero: " + somethingElse
    }

  def main(args: Array[String]): Unit = {
  
    println(describe(0))
    println(describe("hello"))
    println(describe(Nil))
    println(describe(List(1,2,3)))
  }
}