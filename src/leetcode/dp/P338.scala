package leetcode.dp
//0	1	1	2	1	2	2	3	1	2	2	3	2	3	3	4	1	2
//0	1	1	2	1	2	2	3	1	2	2	3	2	3	3	4	1	2
//0	1	10	11	100	101	110	111	1000	1001	1010	1011	1100	1101	1110	1111	10000	10001

object P338 {

  def countBits(num: Int): Array[Int] = {
    if(num == 0) return Array(0) 
    if(num == 1) return Array(0, 1)
    
    val dp = Array.fill(num + 1)(0) 
    dp(0) = 0
    dp(1) = 1
    
    var pow = 2
    var index = 0
    for (i <- 2 to num) {
       if( i == pow){
         index = pow
         pow = pow * 2         
       }
       dp(i) =  dp(i - index) + 1        
    }

    return dp
  }

  def main(args: Array[String]) {
    var a = 17
    println(countBits(a).mkString("\t"))
  }
  
  def count(s :String) : Int ={
    var sum = 0
    for( i <- 0 to s.length() - 1 ){
       if(s.charAt(i) =='1') {
          sum += 1
       }
    }
    return sum
  }

}