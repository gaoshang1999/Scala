package programming_in_scala_2nd.ch9

object ByNameParameters {
  
  val assertionsEnabled  = false
  
  def byNameAssert(predicate: => Boolean) =
    if (assertionsEnabled && !predicate)
      throw new AssertionError
      
      
  def main(args: Array[String]): Unit = {
    
      println(byNameAssert(5 > 3))
      
      println(byNameAssert(4 / 0 == 0))
  }
}