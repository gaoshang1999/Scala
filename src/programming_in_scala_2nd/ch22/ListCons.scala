package programming_in_scala_2nd.ch22

object ListCons {
  abstract class Fruit
  class Apple extends Fruit
  class Orange extends Fruit

  def main(args: Array[String]): Unit = {
    val apples = new Apple :: Nil

    val fruits = new Orange :: apples
    println(fruits.getClass)
    
    val list1 = List (1, 2, 3)
    val list2 = List( 6, 7)
    
    println( list1 ::: list2)
  }
}