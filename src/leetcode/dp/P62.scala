package leetcode.dp

object P62 {
  def uniquePaths(m: Int, n: Int): Int = {
     var table = Array.fill(m, n)(0)
     table(0)(0) = 1

     for( i <- 0 to m-1){
       for (j <- 0 to n-1){
          if (i!= 0 || j!= 0)
            table(i)(j) = (if(j-1>=0)table(i)(j-1) else 0) + (if(i-1>=0)table(i-1)(j)else 0)
       }
     }
     
      println(table.map(_.mkString("\t")).mkString("\n"))
     
     return table(m-1)(n-1)
  }

  def main(args: Array[String]) {
//    println(uniquePaths(2, 2))
//    
//    println(uniquePaths(3, 3))
    
    Range(0, 10).map(i=> println(i))
  }
}