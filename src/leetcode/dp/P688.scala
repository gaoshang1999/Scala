package leetcode.dp

import  scala.collection.mutable.ArrayBuffer


object P688 {
  
  val eightStep = Array(Array(-2, 1), Array(-1, 2), Array(1, 2), Array(2, 1), Array(2, -1), Array(1, -2), Array(-1, -2), Array(-2, -1))
     
  
  def knightProbability_brute_force(N: Int, K: Int, r: Int, c: Int): Double = {
     val nextStep = Array.fill(N, N)(new ArrayBuffer[Array[Int]]())    
     
 
     for( i <- 0 to N-1)
       for ( j <- 0 to N-1){
          for ( k <- 0 to eightStep.length-1){
              val a = eightStep(k)
              val ni = i + a(0)
              val nj = j + a(1)
              if( ni >= 0 && ni < N && nj>=0 && nj < N){
                    nextStep(i)(j).append(Array(ni, nj))
              }
          }
       }
     
     var p:Double = 1;     
     var g1 : ArrayBuffer[Array[Int]] = new ArrayBuffer[Array[Int]]()
     var g2 : ArrayBuffer[Array[Int]] = new ArrayBuffer[Array[Int]]()
     g1.append(Array(r, c))
     var k = K 
     while(k > 0 ){

       var p1 = 1.0 / g1.length   
       var p2 = 0.0
       for( m <- 0 to g1.length-1){
         val square =  g1(m)
         val (i, j) = (square(0), square(1))
         p2 = p2 +  p1 * (nextStep(i)(j).length/8.0)
         for( n <-0 to nextStep(i)(j).length-1){
            g2.append( nextStep(i)(j)(n) )
         }
       }
       
       p = p * p2
       
       g1.clear()
       
       val temp = g1
       g1 = g2
       g2 = temp
       
       k -= 1
     }
    
     return p
  }
  
  def knightProbability_recursive_brute_force(N: Int, K: Int, r: Int, c: Int): Double = {
      if ( K == 0) {
        return 1
      }      
      var p = 0.0
      for ( k <- 0 to eightStep.length-1){
              val a = eightStep(k)
              val ni = r + a(0)
              val nj = c + a(1)
              if( ni >= 0 && ni < N && nj>=0 && nj < N){
                    p +=  1.0/8 * knightProbability_recursive_brute_force(N, K-1, ni, nj)
              }
     }
      
     return p
  }
  
  def knightProbability_dp(N: Int, K: Int, r: Int, c: Int): Double = {
     var initStep = Array.fill(N, N)(1.0)    
     var nextStep = Array.fill(N, N)(0.0)    
     
     for( t <- 1 to K){
        for( i <- 0 to N-1)
        for ( j <- 0 to N-1){
          for ( k <- 0 to eightStep.length-1){
              val a = eightStep(k)
              val ni = i + a(0)
              val nj = j + a(1)
              if( ni >= 0 && ni < N && nj>=0 && nj < N){
                    nextStep(ni)(nj) +=  1.0/8 * initStep(i)(j) 
              }
          }
        
       }
        
//       println(nextStep.map(_.mkString).mkString("\n"))
//       println
       initStep = nextStep
       nextStep = Array.fill(N, N)(0.0) 
     }
     
     return initStep(r)(c)
  }
  
  def main(args: Array[String]): Unit = { 
 
     println(knightProbability_recursive_brute_force(3, 2, 0, 0));
     println(knightProbability_recursive_brute_force(3, 10, 0, 0));
     println(knightProbability_recursive_brute_force(8, 3, 6, 4));
     
     println(knightProbability_dp(3, 2, 0, 0));
     println(knightProbability_dp(3, 10, 0, 0));
     println(knightProbability_dp(8, 30, 6, 4));
  }
}