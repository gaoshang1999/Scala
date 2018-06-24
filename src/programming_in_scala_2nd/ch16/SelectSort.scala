package programming_in_scala_2nd.ch16

import scala.util.Random


object SelectSort {
  def ssort(xs: List[Int]): List[Int] = xs match {
    case List()   => List()
    case x :: xs1 => select(x, ssort(xs1))
  }
  def select(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x <= y) x :: xs
        else y :: select(x, ys)
  }

  def main(args: Array[String]): Unit = {
    val n = 10
    val rands = List.fill(n)(Random.nextInt(100))
    println(rands.mkString(", "))
    val sorts = ssort(rands)
    println(sorts.mkString(", "))
  }
}