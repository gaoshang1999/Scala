package programming_in_scala_2nd.ch16

import scala.util.Random

object InsertSort {
  def isort(xs: List[Int]): List[Int] = xs match {
    case List()   => List()
    case x :: xs1 => insert(x, isort(xs1))
  }
  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x <= y) x :: xs
    else y :: insert(x, ys)
  }

  def main(args: Array[String]): Unit = {
    val n = 10
    val rands = List.fill(n)(Random.nextInt(100))
    println(rands.mkString(", "))
    val sorts = isort(rands)
    println(sorts.mkString(", "))
  }
}