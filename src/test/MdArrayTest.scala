package test

import scala.collection.mutable.ArrayBuffer

object MdArrayTest {
  
  def pascal(n:Int) : Array[Array[Int]] = {    
     val ret:Array[Array[Int]] = new Array[Array[Int]](n) 
     
     for (i <- 0 to n-1){
        val  row :Array[Int] =  new Array[Int](i+2)
        for(j <- 0 to i+1){
           if(j == 0 || j == i+1){
             row(j) = 1
           }else{
             val v = ret(i-1)(j) + ret(i-1)(j-1)
             row(j) = v
           }           
        }
        ret(i) = row
     }
     return ret
  }
  
  
  
  def main(args: Array[String]): Unit = {
     val a = pascal(5)
     println(a.map(_.mkString(",")).mkString("\n"))
  }
  
}