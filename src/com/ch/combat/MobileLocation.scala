package com.ch.combat

import org.apache.spark.{SparkConf, SparkContext}

object MobileLocation {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("mobileLocation")
    val sc = new SparkContext(conf)
//    读取文件
    val lines = sc.textFile("./日志数据.txt")
    //        数据过滤，去除空行
    val plc2 = lines.filter(x => x.length > 1)
    plc2.foreach(x=>{
      println(x.substring(20,26))
      println(x.length)
    })
    println(plc2.count())
//    数据过滤,分割出时间中的时分秒，剔除在9：00~17.30之外的数据
    val plc1 = plc2.filter((x=>(
        90000 < x.substring(20,26).toInt && x.substring(20,26).toInt<173000
      )))
    println(plc1.count())
//    切分
    val plc = plc1.map(line => {
//      按逗号切分得到数组
    val fields = line.split(",")
//      第一个为电话号码
    val phoneNumber = fields(0)
//      第三个为基站ID
    val loc = fields(2)
//      第四个为连接类型，即是否连接
    val tp = fields(3)
//      第二个为连接时间，在这我们认为tp=1时手机刚连接，0为终止连接，那么如果为1时为负值，好计算终止连接和刚连接之间的时间间隔
    val time = if(tp == "1") -fields(1).toLong else fields(1).toLong
//      返回数据（（电话号码,基站ID）,时间,连接）
    ((phoneNumber, loc), time)
    })
//    整合数据
    val result1 = plc.reduceByKey(_ + _)

//    result1.foreach(println)
//    剔除时间为负的值,因为时间为负的原因是在9：00~17：30这段时间内连接后未断开，
//    可以认为手机主人在17：30依旧在使用基站服务(未下班)，用这个点将时间转正
    val value = result1.map(x => {
//    时间为正不变，反之转正
      if (x._2 < 0){
        val  t = 173000 - x._2.toString.substring(9,15).toLong
//        将基站ID作为key，电话号码和时间作为value
        (x._1._2, (x._1._1, t))
      }
      else
        (x._1._2, (x._1._1, x._2))
    })
    value.foreach(println)
    val location = sc.textFile("./基站表数据.txt")
    val locationInfo = location.map(line => {
//      按|和,分割.  注意：|需要\\转义
      val fields = line.split("\\||,")
//      基站ID
      val id = fields(0)
//      经度
      val j = fields(1)
//      纬度
      val w = fields(2)
      (id, (j, w))
    })
    locationInfo.foreach(println)
//    连接join (基站ID,((手机号，时间)(经度，纬度)))
    val result2 = value.join(locationInfo)
    val result3 = result2.groupBy(_._2._1._1)
    val result4 = result3.mapValues(x => {
//      将排序结果倒过来，取通讯时间保持最长的数据
      x.toList.sortBy(_._2._1._2).reverse.take(1)
    })
    result4.foreach(println)
    sc.stop()

  }

}
