package programming_in_scala_2nd.ch7

object ControlStructures {
  def main(args: Array[String]): Unit = {

    //    var line = ""
    //    while ((line = readLine()) != "") // This doesn’t work!
    //      println("Read: " + line)

    var line = ""
    do {
      line = readLine()
      println("Read: " + line)
    } while (line != "")

    val filesHere = (new java.io.File(".")).listFiles
    for (file <- filesHere)
      println(file)

    def scalaFiles =
      for {
        file <- filesHere
        if file.getName.endsWith(".scala")
      } yield file
  }
}