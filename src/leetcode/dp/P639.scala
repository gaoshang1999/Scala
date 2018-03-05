package leetcode.dp


object P639 {
   
    def numDecodings(s: String): Int = {
        val n = s.length
        if(n==0) return 0
        val dp  =  Array.fill[BigInt](n,n)(0)      
        
        for( i <- 0 to n-1){
            for( j <- 0 to n-i-1){
                if( j == i+j){
                    dp(j)(i+j) = isValid(s(j).toString)
                }else{                  
                    val v : BigInt = if(j+2<n) dp(j+2)(i+j) else 1;
                    dp(j)(i+j)=  dp(j+1)(i+j) * isValid(s.substring(j, j+1))  +  v * isValid(s.substring(j, j+2))  
                }                
            }
        }
        println( dp.map(_.mkString("\t")) .mkString("\n"))
            
        return (dp(0)(n-1) % ( Math.pow(10, 9).toInt + 7)) .toInt
    }
    
    def isValid(c : String): Int = {
       if ( c.contains("*")){      
              if( c.length == 1 ){
                 return 9
              }else if( c(0) == '*'){
                  if( c(1) == '*'){
                    return 15
                  }else if( c(1)  >= '0' && c(1)  < '7'){
                     return 2
                  }else {                     
                     return 1
                  }
              }else {
                if( c(0) == '1'){
                  return 9
                }else if(c(0) == '2'){
                  return 6
                }
              }
              
              return 0
       }
      
      
       if ( c(0) != '0' && c. toInt > 0 && c.toInt < 27 ){
         return 1
       }       

       
       return 0
    }

    

 
    
    def main(args: Array[String]) {
       var s = "1*"
//       println(numDecodings(s))
//       
//       s = "3*"
//       println(numDecodings(s))
//       
//        s = "*1"
//       println(numDecodings(s))
//       
//       s = "*********"
//       println(numDecodings(s))
       
       //133236775
//       s = "**********1111111111"
//       println(numDecodings(s))
////       
       //104671669
       s = "********************"
       println(numDecodings(s))
       
    }

}