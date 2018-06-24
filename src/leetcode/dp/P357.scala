package leetcode.dp

import scala.math._
import scala.collection.immutable.HashSet

/*357. Count Numbers with Unique Digits
DescriptionHintsSubmissionsDiscussSolution
Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
*/

object P357 {

  def countNumbersWithUniqueDigits(n: Int): Int = {
    assert(n > 0)
    
    val num = pow(10, n).toInt 
    var cnt = 0
    for( i<- 0 to num -1){
      if( ! isUniqueDigits(i)) {
        cnt +=1
        if( hasRepeat (i)) println(i)
//        println(i)
      }
    }
    
    println("recuisive: "+countNumbersWithUniqueDigits_recuisive(n))
    return  cnt
    return  num - cnt
  }
  
  def countNumbersWithUniqueDigits_recuisive(n: Int): Int = {
      if (n == 1) return 0
      if (n == 2) return 9
      return (n * pow(10, n-2).toInt - (n-1)) * 9 + countNumbersWithUniqueDigits_recuisive(n-1)
    
  }
  
  def isUniqueDigits(n: Int): Boolean = {
     val s = n.toString
 
     var set = collection.mutable.Set[String]()
     for (c <- s) set.add(c.toString())

     if(set.size == s.length()) return true;
     return false;
  }
  
  def hasRepeat (n: Int): Boolean ={
     if( !isUniqueDigits(n) && n >= 1000 && n < 2000)    
       return true;
     
     return false
  }

  def main(args: Array[String]) {
//    println( countNumbersWithUniqueDigits(2) )
// 
//    println( countNumbersWithUniqueDigits(3) )
    println( countNumbersWithUniqueDigits(4) )   
     
//    println( countNumbersWithUniqueDigits(5) )    
//    println( countNumbersWithUniqueDigits(8) )
//    println(isUniqueDigits(11))
//    
//    println(isUniqueDigits(10))
  }

  
  /**
   * 1  0
   * 2  9 
   * 3  (30 -2 ) * 9 + 9  = 29 * 9 = 261
   * 
   * 
   */
}