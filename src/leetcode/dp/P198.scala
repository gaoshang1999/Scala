package leetcode.dp

object P198 {
  
    // 1 1 1 ->2
    // 2 1 3 10 -> 12
    // 1 2 3 10 -> 12
    //[2,3,2] -> 4
    def rob(nums: Array[Int]): Int = {
        val n = nums.length
        if (n == 0) return 0
        if (n==1) return 0.max(nums(0))
        var a = nums(0)
        var b = nums(1)
        
        var i = 2
        while( i < n ){
          
          a += nums(i)
          b += nums(i+1)
          
          a = a.max(a-nums(i) +nums(i+1))
          
          i += 1
        }   
        
        if(n%2==1 && nums(i-1) <= nums(i-2)){
//           sum += nums(n-1)
        }
        
        return a.max(b)
    }
    
    def main(args: Array[String]) {
       var a = Array(0)
       println(rob(a))       
       
       a = Array(1, 1, 1 );
       println(rob(a))
       
       a = Array(2, 1, 3, 10 );
       println(rob(a))
       
       a = Array(2, 1, 3, 10, 100 );
       println(rob(a))
       
       a = Array(1, 2, 3, 10 );
       println(rob(a))     
       
       a = Array(2, 3, 2);
       println(rob(a))   
    }
}