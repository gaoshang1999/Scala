package programming_in_scala_2nd

object MapTest {
  def main(args: Array[String]): Unit = {
    var capital = Map("US" -> "Washington", "France" -> "Paris")
    capital += ("Japan" -> "Tokyo")
    println(capital("France"))
    println(capital("Japan"))
  }
}