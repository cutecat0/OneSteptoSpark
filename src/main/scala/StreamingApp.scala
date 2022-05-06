import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.{Seconds, StreamingContext}

object StreamingApp {
  def main(args: Array[String]): Unit = {
    if (args.length < 2) {
      System.err.println("Usage: NetworkWordCount <hostname> <port>")
      System.exit(1)
    }
//    StreamingExamples.setStreamingLogLevels()
    // Create a local StreamingContext
    val conf = new SparkConf().setMaster("local").setAppName("NetWorkWordCount")
    val ssc = new StreamingContext(conf, Seconds(1))

    // create a DStream that will connect to hostname:port, here is localhost:9999
    //  val lines = ssc.socketTextStream("localhost", 9999)
    val lines = ssc.socketTextStream(args(0), args(1).toInt, StorageLevel.MEMORY_AND_DISK_SER)


    // spilt each line into words
    val words = lines.flatMap(_.split(" "))

    // count each word in each batch
    val pairs = words.map(word => (word, 1))
    val wordCounts = pairs.reduceByKey(_ + _)
    wordCounts.print()

    ssc.start()
    ssc.awaitTermination()
  }
}

// run steps :
// step 1: edit simple.sbt file , add libraryDependencies += "org.apache.spark" %% "spark-streaming" % "3.2.1"
// step 2: run $ sbt package
// step 3: run $ nc -lk  9999  this command use NetCat as your own database server
// step 3: run the follow command:
///xxx/spark-3.2.1-bin-hadoop3.2/bin/spark-submit \
//  --class "StreamingApp" \
//  --master local \
//  /xxx/OneSteptoSpark/target/scala-2.12/simple-project_2.12-1.0.jar localhost 9999
