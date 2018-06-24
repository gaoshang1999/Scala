package advanced_analytics_with_spark

//import org.apache.spark.util.StatCounter
//
//class MytatCounter extends Serializable {
//  val stats: StatCounter = new StatCounter()
//  var missing: Long = 0
//  def add(x: Double): MytatCounter = {
//    if (java.lang.Double.isNaN(x)) {
//      missing += 1
//    } else {
//      stats.merge(x)
//    }
//    this
//  }
//  def merge(other: MytatCounter): MytatCounter = {
//    stats.merge(other.stats)
//    missing += other.missing
//    this
//  }
//  override def toString = {
//    "stats: " + stats.toString + " NaN: " + missing
//  }
//}
//object MytatCounter extends Serializable {
//  def apply(x: Double) = new MytatCounter().add(x)
//}