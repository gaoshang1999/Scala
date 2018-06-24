package leetcode.array

import scala.collection.mutable.ArrayBuffer
 
object P295 {
  class MedianFinder() {

    /** initialize your data structure here. */
    val buffer = new ArrayBuffer[Int]();

    def addNum(num: Int) {
      def helper(l: Int, r: Int): Int = {
        if (l == r)          
          if (Seq(0, l).contains(this.buffer.length) || this.buffer(l) > num)
            return l
          else return l + 1
        else if (l > r)
          return r + 1
        val m = (l + r) / 2

        if (this.buffer(m) == num)
          return m
        else if (this.buffer(m) < num)
          return helper(m + 1, r)
        else
          return helper(l, m - 1)
      }
      
      val i = helper(0, this.buffer.length)
      this.buffer.insert(i, num)
    }

    def findMedian(): Double = {
        val n = this.buffer.length
        val m = n / 2
        if (n % 2 == 1)
            return this.buffer(m).toDouble
        else 
            return ( (this.buffer(m) + this.buffer(m-1) ) /2 ).toDouble     
    }

  }

}