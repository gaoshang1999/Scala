package programming_in_scala_2nd.ch24

object SetTest {
  
  def main(args: Array[String]): Unit = {
      var s = Set(1, 2, 3)    
      s += 4;
      
      println(s)
      
      val ms = collection.mutable.Set(1, 2, 3)
      
      ms += 4
      println(ms)
      
  }
  
}