package programming_in_scala_2nd.ch12

object StackableTrait {
  abstract class IntQueue {
    def get(): Int
    def put(x: Int)
  }

  import scala.collection.mutable.ArrayBuffer
  class BasicIntQueue extends IntQueue {
    private val buf = new ArrayBuffer[Int]
    def get() = buf.remove(0)
    def put(x: Int) { buf += x }
  }

  trait Doubling extends IntQueue {
    abstract override def put(x: Int) { super.put(2 * x) }
  }

  trait Incrementing extends IntQueue {
    abstract override def put(x: Int) { super.put(x + 1) }
  }
  trait Filtering extends IntQueue {
    abstract override def put(x: Int) {
      if (x >= 0) super.put(x)
    }
  }

 

  def main(args: Array[String]): Unit = {
    val queue = (new BasicIntQueue with Doubling with Incrementing)

    queue.put(-1); queue.put(0); queue.put(1); queue.put(2)

    println(queue.get())
    println(queue.get())
    println(queue.get())
    println(queue.get())
  }
}