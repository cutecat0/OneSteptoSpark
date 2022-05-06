import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object SimpleApp {
  def main(args: Array[String]) {
    val logFile = "/Users/xxx/Downloads/spark-3.2.1-bin-hadoop3.2/bin/README.md"
    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println("Lines with a: %s \n Lines with b: %s".format(numAs, numBs))

//    test here
    val lines = sc.textFile("text.txt")
    val pairs = lines.map(s => (s, 1))
    val counts = pairs.reduceByKey((a, b) => a + b)
  }
}

// Use spark-submit to run your application
//$ YOUR_SPARK_HOME/bin/spark-submit \
//--class "SimpleApp" \
//--master local[4] \ here I run local without [4]
//  target/scala-2.12/simple-project_2.12-1.0.jar
//  ...
//Lines with a: 14
// Lines with b: 7

