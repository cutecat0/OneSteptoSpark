Spark context Web UI available at http://xxx
Spark context available as 'sc' (master = local[*], app id = local-xxx).
Spark session available as 'spark'.
Welcome to
____              __
/ __/__  ___ _____/ /__
_\ \/ _ \/ _ `/ __/  '_/
/___/ .__/\_,_/_/ /_/\_\   version 3.2.0
/_/

Using Scala version 2.12.15 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_241)
Type in expressions to have them evaluated.
Type :help for more information.

scala> val textFile = sc.textFile("README.md")
textFile: org.apache.spark.rdd.RDD[String] = README.md MapPartitionsRDD[1] at textFile at <console>:23

scala> textFile.count()
res0: Long = 27

scala> textFile.first()
res1: String = Apache Spark: 用于大数据处理的集群计算框架

scala> val lineWithSpark = textFile.filter(line => line.contains("spark"))
lineWithSpark: org.apache.spark.rdd.RDD[String] = MapPartitionsRDD[2] at filter at <console>:23

scala> lineWithSpark.count()
res2: Long = 0

scala> textFile.filter(line => line.contains("Spark")).count()
res3: Long = 10

scala> textFile.map(line => line.split(" ").size).reduce((a, b) => if (a > b) a else b)
res4: Int = 10

scala> import java.lang.Math
import java.lang.Math

scala> textFile.map(line => line.split(" ").size).reduce((a, b) => Math.max(a, b))
res5: Int = 10

scala> val wordCounts = textFile.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey((a, b) => a + b)
wordCounts: org.apache.spark.rdd.RDD[(String, Int)] = ShuffledRDD[8] at reduceByKey at <console>:24

scala> wordCounts.collect()
res6: Array[(String, Int)] = Array((中的任务一样,1), (分布于集群中的,1), (分区存储,1), (或,1), (这些阶段又被,1), (运行环境,1), (弹性分布式数据集是所有,1), (任务并行运行在,1), (是集群中,1), (【高,1), (上加载】,1), (任务（task）,1), (作为执行引擎，而是使用了,1), (多个,1), (多个机器,1), (Apache,1), (Dataset,,1), (MapReduce,5), (分析工具,1), (构成,1), ("",12), (对象集合,1), (它自己的分布式环境在集群上执行工作,1), (map,1), (在性能上,1), (【,1), (的一个,1), (分区上，就像,1), (的数据集始终要从,1), (超过了,1), (RDD,5), (弹性分布式数据集——弹性：,1), (reduce,1), (中的,1), (个数量级】,1), (有向无环图,1), (Spark,9), (的出色平台,1), (最突出的表现在于它能将作业于作业之间产生的大规模的工作数据集存储在内存中,1), (只读,1), (是,1), (作业由任意的,1), (Distributed,1), (还是用于构建,1), (above,1), (阶段,2), (来,1), ((Resilient,1), (丢失的分区,1), (自动重建,1), (等效的,1), (弹性分布式数据集),1), (磁盘,1), (可以通过重新安排计算,1), (程序的核心,1), (多阶段（stages）,1), (makes,1), (用于大数据处理的集群计算框架,1), (概念,1), (并没有以,1), (1,1), (Spark:,...

scala>