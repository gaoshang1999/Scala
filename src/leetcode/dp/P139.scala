package leetcode.dp

object P139 {

  def wordBreak(s: String, wordDict: List[String]): Boolean = {
    val array = wordDict.sorted.toArray
    val n = s.length
    val dp = Array.fill[Boolean](n, n)(false)

    for (i <- 0 to n - 1) {
      for (j <- 0 to n - i - 1) {
        if (j == i + j) {
          dp(j)(i + j) = binarySearch(array, s.substring(j, i + j + 1))
        } else {
            var v =  binarySearch(array, s.substring(j, i + j + 1))
            if (v){
              dp(j)(i + j) = v
            }else{
              var b = false
              var k = j
              while( k<= i+j-1 && !b ){
                  v = dp(j)(k) && dp(k+1)(i+j) 
                  if (v){
                    dp(j)(i + j) = v
                    b = true
                  }
                  k += 1
              }
            }
        }
      }
    }
    println(dp.map(_.mkString("\t")).mkString("\n"))
    return dp(0)(n - 1)
  }


  def binarySearchIterative(list: Array[String], target: String): Int = {
    var left = 0
    var right = list.length - 1
    while (left <= right) {
      val mid = left + (right - left) / 2
      if (list(mid) == target)
        return mid
      else if (list(mid) > target)
        right = mid - 1
      else
        left = mid + 1
    }
    -1
  }  
  
  def binarySearch(arr: Array[String], key: String): Boolean = {
      return binarySearchIterative(arr,key) >= 0
  }

  def main(args: Array[String]) {
    var s = "aaaaaaa"
 
    var dict = List("aaaa","aa")
    println(wordBreak(s, dict));

 
    

  }

}