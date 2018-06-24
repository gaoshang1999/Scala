package programming_in_scala_2nd.ch4
import ChecksumAccumulator.calculate


object Summer {
  def main(args: Array[String]) {
    for (arg <- args)
      println(arg + ": " + calculate(arg))
  }
}