package leetcode.dp

object P152 {
   def maxProduct1(nums: Array[Int]): Int = {

    val n = nums.length
    val accProd = Array.fill[Int](n+1)(1)
    for (i <- 1 to n ) {
      accProd(i) = (if(accProd(i-1)!=0) accProd(i-1) else 1)  * nums(i-1)
    }
    println(accProd.mkString("\t")) 
    var mx = Int.MinValue
    for (i <- 0 to n - 1) {
      for (j <- 0 to n - i - 1) {
        var v = 1;
        if (j == i + j) {
           v =  nums(j) 
        } else {
           v =  ( if( accProd(j) !=0 ) accProd(i + j)/accProd(j)  else 1 )  * nums(i + j)    
        }
        println(v)
        mx = mx.max(v)
      }
    }

    return mx
  }


  def maxProductx(nums: Array[Int]): Int = { 
      val n = nums.length;
      var mx = nums(0)
      var a = mx
      var b = mx      
      
      for( i<- 1 to n-1){ 
          val v = nums(i) * b
          a = nums(i) * a
          if( v > 0 ){
             mx = mx.max(v)             
          }else if( nums(i-1) == 0 ) {
             a = nums(i)
             b = nums(i)             
          }else{
             b= nums(i)
          }
           mx = mx.max(a)     
           mx = mx.max(b)
      }
      
      return mx   
  }
  
    def maxProduct(nums: Array[Int]): Int = {  println()
      val n = nums.length;
      var (mx, mn, big, small) = (nums(0), nums(0), nums(0), nums(0))
   
      
      for( i<- 1 to n-1){ 
          if ( nums(i) < 0 ){
              val tmp = big
              big = small
              small = tmp
          }
        
          val v1 = nums(i) * big
          val v2 = nums(i) * small
         
          big = nums(i).max(v1)
          small = nums(i).min(v2)
          mx = mx.max(big)
          mn = mn.min(small)
          println(mx, mn, big, small)          
      }
      
      return mx   
  }
  
  
  def main(args: Array[String]) {
    var s = Array(2,3,-2,4)
 
    println(maxProduct(s));

 
    s = Array(-2,3,-2, -1)
 
    println(maxProduct(s));

        
    s = Array(-3,0,1,-2)
 
    println(maxProduct(s));  
     
    s = Array(0, 2) 
    println(maxProduct(s));  
    
    s = Array(3,-1,4)
    println(maxProduct(s));  
    
    s = Array(-2,0,-1)
    println(maxProduct(s));  
    
     s = Array(2,-5,-2,-4,3)
    println(maxProduct(s));  
  }
}