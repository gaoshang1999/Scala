package leetcode.dp

object P91 {
   
    def numDecodings(s: String): Int = {
        val n = s.length
        if(n==0) return 0
        val dp  =  Array.ofDim[Int](n,n)
        
        for( i <- 0 to n-1){
            for( j <- 0 to n-i-1){
                if( j == i+j){
                    dp(j)(i+j) = isValid(s(j).toString)
                }else{                  j
                    dp(j)(i+j)= isValid(s.substring(j, j+1)) * dp(j+1)(i+j) + isValid(s.substring(j, j+2))  * (if(j+2<n) dp(j+2)(i+j) else 1)
                }
                
            }
        }
//        println( dp.map(_.mkString("\t")) .mkString("\n"))
            
        return dp(0)(n-1)
    }
    
    def isValid(c : String): Int = {
       if ( c(0) != '0' && c.length < 3  && c. toInt > 0 && c.toInt < 27 ){
         return 1
       }
       return 0
    }

    
    def dcMethod(s : String): Int = {
        if(s. length == 0){
          return 1
        }
        
        var count :Int = 0
        for ( i <- 0 to Math.min(s.length -1, 1)){
          val c = s.substring(0, i+1)
          if ( c(0) != '0' && c. toInt > 0 && c.toInt < 27 ){
//             println(c, s.substring(i+1))
             count += dcMethod(s.substring(i+1))
          }
            
        }
        
        return count
    }
 
    
    def main(args: Array[String]) {
       var s = "12"
       println(numDecodings(s))
       
       s = "123"
       println(numDecodings(s))
       
        s = "1234"
       println(numDecodings(s))
       
       s = "101"
       println(numDecodings(s))
       
       s = "6065812287883668764831544958683283296479682877898293612168136334983851946827579555449329483852397155"
       println(numDecodings(s))
//       
//       //5898240
       s = "1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565"
       println(numDecodings(s))
    }

}