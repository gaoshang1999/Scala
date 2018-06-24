package scalabyexample

abstract class Stack[A] {
  def push(x: A): Stack[A] = new NonEmptyStack[A](x, this)
  def isEmpty: Boolean
  def top: A
  def pop: Stack[A]
}
class EmptyStack[A] extends Stack[A] {
  def isEmpty = true
  def top = sys.error("EmptyStack")
  def pop = sys.error("EmptyStack")
}
class NonEmptyStack[A](elem: A, rest: Stack[A]) extends Stack[A] {
  def isEmpty = false
  def top = elem
  def pop = rest
}
object Stack {

  def main(args: Array[String]): Unit = {

    val x = new EmptyStack[Int]
    val y = x.push(1).push(2)
    println(y.pop.top)
    val z = y.pop
    println(z.pop.top)
    println(y.pop.top)
  }
}