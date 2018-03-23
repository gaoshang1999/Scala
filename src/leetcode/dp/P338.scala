package leetcode.dp
//0	1	1	2	1	2	2	3	1	2	2	3	2	3	3	4	1	2
//0	1	1	2	1	2	2	3	1	2	2	3	2	3	3	4	1	2
//0	1	1	2	1	2	2	3	1	2	2	3	2	3	3	4	1	2
//0	1	10	11	100	101	110	111	1000	1001	1010	1011	1100	1101	1110	1111	10000	10001

object P338 {
  
  def countBitsx(num: Int): Array[Int] = {
        val dp = Array.fill(num + 1)(0) 
        dp(0) = 0

        var pow = 1
        var index = 0
        for (i <- 1 to num) {
           if( i == pow){
             index = pow
             pow = pow * 2         
           }
           dp(i) =  dp(i - index) + 1        
        }

        return dp     
    }

  def countBits(num: Int): Array[Int] = {
    
    val dp = Array.fill(num + 1)(0) 
    dp(0) = 0
    
    for (i <- 1 to num) {      
       dp(i) =  dp(i /2 ) + i%2      
    }

    return dp
  }

  def main(args: Array[String]) {
    var a = 17
    println(countBits(a).mkString("\t"))
    
    a = 0
    println(countBits(a).mkString("\t"))
  }
  
 

}