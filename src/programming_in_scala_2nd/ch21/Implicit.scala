package programming_in_scala_2nd.ch21

object Implicit {

  def maxList[T <% Ordered[T]](elements: List[T]): T =
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxList(rest) // (orderer) is implicit
        if (x > maxRest) x // orderer(x) is implicit
        else maxRest
    }

//  implicit def intToDigits(i: Int) =
//    i.toString.toList.map(_.toInt)
    
  implicit def intToRange(i: Int) = 1 to i

  def main(args: Array[String]): Unit = {

    val a = maxList(List(1, 5, 10, 3))
    println(a)

    val b = maxList(List(1.5, 5.2, 10.7, 3.14159))
    println(b)

    val c = maxList(List("one", "two", "three"))
    println(c)

    printLength(123)
  }

  def printLength(seq: Seq[Int]) = println(seq.length)

}