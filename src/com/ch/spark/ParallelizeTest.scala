package com.ch.spark

import org.apache.spark.{SparkConf, SparkContext}

object ParallelizeTest {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("parallelize")
    val sc = new SparkContext(conf)
    val rdd = sc.parallelize(Array(1, 2, 3, 4), 1)
    sc.stop()
  }

}
