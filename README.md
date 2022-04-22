# OneSteptoSpark
Recoding spark learning <br>

step 1: download one spark from the office site<br>
https://www.apache.org/dyn/closer.lua/spark/spark-3.2.1/spark-3.2.1-bin-hadoop3.2.tgz<br>

step 2: come to the above dir /bin/spark-shell<br>

<img width="728" alt="截屏2022-04-22 下午5 22 02" src="https://user-images.githubusercontent.com/37787934/164677739-729cd41e-1f61-45a0-94f4-620cb708c77c.png">





okay, here we start to the traveling of spark basic.<br>

`
scala> textFile.map(line => line.split(" ").size).reduce((a, b) => if (a > b) a else b) 
`
<br>
`res3: Int = 21`
