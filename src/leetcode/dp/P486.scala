package leetcode.dp

object P486 {
    def PredictTheWinner(nums: Array[Int]): Boolean = {
        def helper(nums: Array[Int], s:Int, e:Int) : Int = {
            return  if(s==e ) nums(e) else Math.max(nums(e) - helper(nums, s, e-1), nums(s) - helper(nums, s+1, e));
        }
        
        return helper(nums, 0, nums.length-1) > 0;
        
       

    }
    
  def PredictTheWinner2(nums: Array[Int]): Boolean = {
        val n = nums.length
        val dp  =  Array.ofDim[Int](n,n)
        
        for( i <- 0 to n-1){
            for( j <- 0 to n-i-1){
                if( j == i+j){
                    dp(j)(i+j) = nums(j)
                }else{
                    dp(j)(i+j)= Math.max( dp(j)(j) - dp(j+1)(i+j), dp(i+j)(i+j) - dp(j)(i+j-1))
                }
                
            }
//            println(dp.map(_.mkString("\t")).mkString("\n"))
        }
        
        return dp(0)(n-1) > 0;
    }    
    
    def main(args: Array[String]) {
       var nums = Array( 1, 5, 2)
       println(PredictTheWinner2(nums))
       
       nums = Array( 1, 5, 233, 7)
       println(PredictTheWinner2(nums))
       
//1 ->(5, 2)  max(5-2, 2-5)   1- 3 = -2
//2 ->(1, 5)  max(1-5, 5-1)   2- 4 = -2
//
//
//1 -> (5, 233, 7)  
//      5-> max(233-7, 7-233)  5 - 226 = -221
//      7-> max(5-233, 233-5)  7 - 228 = -221
//			1 - -221 = 222
//7 -> (1, 5, 233)
//      1 -> max(5-233, 233-5)  1 - 228 = -227
//      233 -> max(1-5, 5-1)    233-4 = 229
//                      7 - 229 = -221
    }
}