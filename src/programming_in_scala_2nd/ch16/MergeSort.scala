package programming_in_scala_2nd.ch16

import scala.util.Random

object MergeSort {
  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length;
    if (n <= 1) return xs

    val (first, last) = xs.splitAt(n / 2);

    return merge(msort(first), msort(last))
  }

  def merge(xs: List[Int], ys: List[Int]): List[Int] = {
    (xs, ys) match {
      case (Nil, _) => ys
      case (_, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (x < y) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }

  }

  def msort[T](less: (T, T) => Boolean)(xs: List[T]): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (less(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge(msort(less)(ys), msort(less)(zs))
    }
  }

  def main(args: Array[String]): Unit = {
    val n = 11
    val rands = List.fill(n)(Random.nextInt(100))
    println(rands.mkString(", "))
    val sorts = msort(rands)
    println(sorts.mkString(", "))
  }
}