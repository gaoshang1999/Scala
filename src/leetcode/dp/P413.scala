package leetcode.dp

object P413 {
  def numberOfArithmeticSlices(A: Array[Int]): Int = {
        val n = A.length;
        var sum = 0
        for ( i <- 3 to n){
            sum = sum + n - i + 1
        }
        return sum;
    }
  
  def main(args: Array[String]) {

  }
}