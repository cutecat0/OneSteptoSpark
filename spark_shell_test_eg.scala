import java.lang.Math

// all above run under spark-shell
// which start with scala>
val textFile = sc.textFile("README.md")
// textFile: org.apache.spark.rdd.RDD[String] = README.md MapPartitionsRDD[1] at textFile at <console>:23

textFile.count()
// res0: Long = 21



print(textFile.map(line => line.split(" ").size).reduce((a, b) => Math.max(a, b)))
// res1: Int = 14

val wordCounts = textFile.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey((a, b) => a + b)
// wordCounts: org.apache.spark.rdd.RDD[(String, Int)] = ShuffledRDD[5] at reduceByKey at <console>:24
println(wordCounts)

println(wordCounts.collect())
// res2: Array[(String, Int)] = Array((`,2), (下午5,1), (learning,1), (scala>,1), (download,1), (2:,1), (src="https://user-images.githubusercontent.com/37787934/164677739-729cd41e-1f61-45a0-94f4-620cb708c77c.png">,1), (start,1), (one,1), (here,1), (we,1), ("",9), (>,1), (come,1), (<br>,2), (22,1), (").size).reduce((a,,1), (office,1), (traveling,1), (02",1), (line.split(",1), (basic.<br>,1), (from,1), (OneSteptoSpark,1), (width="728",1), (okay,,1), (step,2), (Recoding,1), (=,1), (textFile.map(line,1), (spark,3), (site<br>,1), (if,1), (21`,1), (a,1), (alt="截屏2022-04-22,1), (dir,1), (Int,1), (above,1), (/bin/spark-shell<br>,1), (#,1), (to,2), (<img,1), (1:,1), (https://www.apache.org/dyn/closer.lua/spark/spark-3.2.1/spark-3.2.1-bin-hadoop3.2.tgz<br>,1), ((a,1), (else,1...

//scala>

