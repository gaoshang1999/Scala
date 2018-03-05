package leetcode.dp

object P53 {
    def maxSubArray(nums: Array[Int]): Int = {
        val n = nums.length;
        val dp  = new Array[Int](n);
        dp(0) = nums(0)
        var mx = dp(0)
        
        for( i<- 1 to n-1){ 
            dp(i) = nums(i) + dp(i-1).max(0);
            println(dp.mkString(","))
            mx = mx.max(dp(i))
        }
        
        return mx
    }
    
    def main(args: Array[String]) {
       var nums = Array(-2,1,-3,4,-1,2,1,-5,4)
       println(maxSubArray(nums))
    }
}