package scalabyexample

import scala.util.Random

object QuickSort {

  def sort(xs: Array[Int]): Array[Int] = {
    if (xs.length <= 1) xs
    else {
      val pivot = xs(xs.length / 2)
      Array.concat(
        sort(xs.filter(_.<(pivot))),
        xs filter (pivot ==),
        sort(xs filter (pivot <)))
    }
  }
  
  def sortx(xs: Array[Int]): Array[Int] = {
    if (xs.length <= 1) xs
    else {
      val pivot = xs(xs.length / 2)
      val (left, right) = xs.partition(_.<(pivot) )
      val (right_e, right_g) = right.partition(pivot ==)
      
      Array.concat(
        sortx(left) ,
        right_e,
        sortx(right_g) )     
    }
  }
 

  def main(args: Array[String]): Unit = {
      val n = 10
      val rands = Array.fill(n)(Random.nextInt(100))
      println(rands.mkString(", "))
      val sorts = sort(rands)
      println(sorts.mkString(", "))
      
      println(sortx(rands).mkString(", "))
  }
}