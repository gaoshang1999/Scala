package leetcode.dp

//Follow up for "Unique Paths":
//
//Now consider if some obstacles are added to the grids. How many unique paths would there be?
//
//An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
//For example,
//There is one obstacle in the middle of a 3x3 grid as illustrated below.
//
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//The total number of unique paths is 2.
//
//Note: m and n will be at most 100.

object P63 {
  def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int = {
      val m = obstacleGrid.length;
      if (m == 0) return 0
      val n = obstacleGrid(0).length
      if (n == 0) return 0
      
      return uniquePaths(m, n, obstacleGrid)
  }
  
  def uniquePaths(m: Int, n: Int, obstacleGrid: Array[Array[Int]]): Int = {
     var table = Array.fill(m, n)(0)
     table(0)(0) = if( obstacleGrid(0)(0) == 1) 0 else 1

     for( i <- 0 to m-1){
       for (j <- 0 to n-1){
          if (i!= 0 || j!= 0){
            if( obstacleGrid(i)(j) == 1){
              table(i)(j) = 0
            }else{
              table(i)(j) = (if(j-1>=0)table(i)(j-1) else 0) + (if(i-1>=0)table(i-1)(j)else 0)
            }
          }
       }
     }
     
      println(table.map(_.mkString("\t")).mkString("\n"))
     
     return table(m-1)(n-1)
  }

  def main(args: Array[String]) {

  }
}