package com.ch.spark

import org.apache.spark.{SparkConf, SparkContext}

object SampleTest {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setMaster("local").setAppName("sampleTest")
    val sc = new SparkContext(conf)
    val lines = sc.textFile("./words")
    val value = lines.sample(true, 0.1)
    value.foreach(println)

    val u = value.filter(s => {
      s.equals("hello ChenYun")
    })
    println(u.count())

    val first = lines.first()
    println(first)

    val a = lines.collect()
    println(a)

    val strings = lines.take(5)
    strings.foreach(println)
  }

}
