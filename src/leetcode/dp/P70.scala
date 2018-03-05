package leetcode.dp

object P70 {

  def climbStairs(n: Int): Int = {     
     var a = 0
     var b = 1
     var c = 0
     for( i <- 0 to n-1){
       c = a + b
       a = b
       b = c
     }     
     
     return c
  }

  def main(args: Array[String]) {
     var a = 3
     println( climbStairs(a) ) 
     
     a = 10
     println( climbStairs(a) ) 
  }
}