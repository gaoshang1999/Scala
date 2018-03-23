package leetcode.dp

//72. Edit Distance
//DescriptionHintsSubmissionsDiscussSolution
//Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
//
//You have the following 3 operations permitted on a word:
//
//a) Insert a character
//b) Delete a character
//c) Replace a character
//http://www.cs.jhu.edu/~langmea/resources/lecture_notes/dp_and_edit_dist.pdf
//https://web.stanford.edu/class/cs124/lec/med.pdf

object P72 {

  def minDistance(word1: String, word2: String): Int = {
    val m = word1.length()
    val n = word2.length()
    if (m == 0) return n
    if (n == 0) return m

    val dp = Array.fill(m + 1, n + 1)(0)
    for (i <- 0 to m) {
      dp(i)(0) = i
    }
    for (j <- 0 to n) {
      dp(0)(j) = j
    }

    for (i <- 1 to m) {
      for (j <- 1 to n) {
        val del = dp(i - 1)(j) + 1 //delete
        val ins = dp(i)(j - 1) + 1 // insert
        val rep = dp(i - 1)(j - 1) + (if (word1(i - 1) == word2(j - 1)) 0 else 1)

        dp(i)(j) = Seq(del, ins, rep).min
      }
    }

    return dp(m)(n)

  }

  def main(args: Array[String]) {

    println(minDistance("", ""))

    println(minDistance("a", "b"))

    println(minDistance("abc", "adc"))
  }

}