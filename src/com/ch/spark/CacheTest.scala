package com.ch.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.storage.StorageLevel
import org.apache.spark.{SparkConf, SparkContext}

object CacheTest {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local").setAppName("cacheTest")
    val sc = new SparkContext(conf)
    val lines: RDD[String] = sc.textFile("./words")
//    sc.setCheckpointDir("./checkpoint")
//    lines.checkpoint()
//    lines.collect()
//    lines.cache()
//    lines.persist()
    lines.persist(StorageLevel.MEMORY_ONLY)
    val startTime = System.currentTimeMillis()
    val l1: Long = lines.count()
    val endTime = System.currentTimeMillis()
    println(l1 + "  " + (endTime-startTime))
    val l2: Long = lines.count()
    println(l2)
    sc.stop()
  }
}
