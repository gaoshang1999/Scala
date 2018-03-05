package leetcode.dp

import scala.collection.mutable.ArrayBuffer

object P376 {
    def wiggleMaxLength(nums: Array[Int]): Int = {
        val n = nums.length;
        if (n == 0) return 0

        val dif = new ArrayBuffer[Int](n-1)
        
        for( i<- 1 to n-1){ 
            val d =  (nums(i) - nums(i-1)).signum
            if ( d!=0 && ( dif.length==0 || d != dif.last)) { 
                dif +=  d
            }
        }
        println("dif: "+ dif.mkString(","))
        

        return dif.length + 1
    }
  
    def main(args: Array[String]) {
       var nums = Array(-2,1,-3,4,-1,2,1,-5,4)
       println(wiggleMaxLength(nums))
       
       nums = Array(0, 0)
       println(wiggleMaxLength(nums))
       
       nums = Array(0, 0,  0)
       println(wiggleMaxLength(nums))
       
        nums = Array(3,3,3,2,5)
       println(wiggleMaxLength(nums))       
    
    }
}