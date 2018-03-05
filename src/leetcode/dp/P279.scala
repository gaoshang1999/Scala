package leetcode.dp

//1 1
//2 1+1
//3 1+1+1
//4 4
//5 4+1
//6 4+1+1
//7 4+1+1+1
//8 4+4
//9 9
//10 9+1
//11 9+1+1
//12 4+4+4
//13 9+4
//14 9+4+1
//15 9+4+1+1
//16 16
//17 16+1
//18 9+9 
//19 9+9+1
//20 16+4
//21 16+4 + 1
//22 9+9+4
//23 9+9+4+1
//24 9+9+4+1+1   16+4+4

object P279 {
    def numSquares(n: Int): Int = {
        val len = Math.sqrt(n).toInt
        val table = Array.fill(len)(1)
        for ( i <- 1 to len-1){
          table(i) = (i+1)*(i+1)
        }
        println(table.mkString("\t"))
        val dp = Array.fill(n+1)(0)
        dp(1) = 1
        print(dp(1) + "\t" )
        for ( i <- 2 to n){
          val sqrt = Math.sqrt(i).toInt
          dp(i) =  1+dp(i - sqrt*sqrt) 
          
          for( j <- 1 to sqrt-1){
            dp(i) =  dp(i).min(1+dp(i - j * j))
          }
            
            print(dp(i) + "\t" )
          if(i%10 == 0)
            println()
        }
        println
        println(dp.mkString("\t"))
        return dp(n)
    }
    
    def main(args: Array[String]) {
      println(numSquares(48))
    }
}