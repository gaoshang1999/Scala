package test

import scala.collection.mutable.ArrayBuffer

object MdArrayBufferTest {
  
  def pascal(n:Int) : Array[Array[Int]] = {    
     val ret:ArrayBuffer[Array[Int]] = new ArrayBuffer[Array[Int]]() 
     
     for (i <- 0 to n-1){
        val  row :ArrayBuffer[Int] =  new ArrayBuffer[Int]()
        for(j <- 0 to i+1){
           if(j == 0 || j == i+1){
             row.append(1)
           }else{
             val v = ret(i-1)(j) + ret(i-1)(j-1)
             row.append(v)
           }           
        }
        ret.append(row.toArray)
     }
     return ret.toArray
  }
  
  
  
  def main(args: Array[String]): Unit = {
     val a = pascal(8)
     println(a.map(_.mkString(",")).mkString("\n"))
  }
  
}