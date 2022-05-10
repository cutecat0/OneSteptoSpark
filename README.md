# OneSteptoSpark
Recoding spark learning <br>

step 1: download one spark from the office site<br>
https://www.apache.org/dyn/closer.lua/spark/spark-3.2.1/spark-3.2.1-bin-hadoop3.2.tgz<br>

step 2: come to the above dir /bin/spark-shell<br>

<img width="728" alt="截屏2022-04-22 下午5 22 02" src="https://user-images.githubusercontent.com/37787934/164677739-729cd41e-1f61-45a0-94f4-620cb708c77c.png">

okay, here we start to the traveling of spark basic.<br>

run scala without spark-shell, use jar<br>
the follow steps are: <br>
`
step 0: logFile path must be the spark-shell path:<br>
    val logFile = "/Users/xxx/Downloads/spark-3.2.1-bin-hadoop3.2/bin/README.md"<br>

step 1:<br>
config simple.sbt<br>
run the follow command to get a jar file<br>
$ sbt package<br>


step 2: after sbt package run the follow command<br>
$ /Users/xxx/Downloads/spark-3.2.1-bin-hadoop3.2/bin/spark-submit \
  --class "SimpleApp" \
  --master local \
/Users/xxx/xxx/OneSteptoSpark/target/scala-2.12/simple-project_2.12-1.0.jar


`

Here is Spark Streaming: <br>
<img width="1020" alt="截屏2022-04-26 下午3 06 33" src="https://user-images.githubusercontent.com/37787934/165242497-9690e902-3f18-415b-9b43-9f2a7625abdf.png">

![截屏2022-05-10 下午2 26 52](https://user-images.githubusercontent.com/37787934/167562405-c8fed238-01c0-4d98-8f3a-b03419d7ab40.png)

