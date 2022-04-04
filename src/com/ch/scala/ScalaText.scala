package com.ch.scala

import java.util.Date

class Person(name:String,age:Int){
  val person_name = name
  var person_age = age
  var person_sex = '男'

  def this(name:String,age:Int,sex:Char) = {
    this(name,age)
    this.person_sex = sex
  }

}

object ScalaText {
  def main(args: Array[String]): Unit = {
    /**
     * 元组
     */
//    val t = (1,12)
//    println(t.swap)
//    val x = new Tuple5(1,2,3,4,5)
//    val y = (1,2,3,4,5,6)
//    println(y._3)
//    val z = y.productIterator
//    while (z.hasNext)
//      println(z.next)

    /**
     * Map
     */
//    val map = Map(1->"hello",2->"c",(3,"qwe"),("a","zxc"))
//    val x = map.get("a").getOrElse("无值")
//    val keys = map.keys
//    val values = map.values
//    keys.foreach(key=>{
//      if(map.get(key).getOrElse("无值").equals("qwe"))
//        println(key)
//    })
//    map.foreach((k,v)=>{
//      if(v.indexOf("qwe")>=0)
//        println(k)
//    })
//    println(x)

    /**
     * set
     */
//    val x = Set(1,3,5,7,"S",1)
//    x.foreach(println)

    /**
     * list
     */
//    val list = List("hello world","hello aaa","hello scala")
//    val x= list.map(s=>{s.split(" ")})
//    // x为数组嵌套
//    x.foreach(p=>{
//      p.foreach(println)
//    })
//    val y = list.flatMap(s=>{s.split(" ")})
//    // y为字符串数组
//    y.foreach(println)
//    val z = list.filter(line=>{line.equals("hello world")})
//    z.foreach(println)

    /**
     * Array
     */
//    val arr = Array(1,1,2,"s")
//    val arr = Array(1,2,3,4,5)
//    arr.foreach(println)
//    for (a<-arr){
//      println(a)
//    }
//    val arr = new Array[String](3)
//    arr(0) = "asd"
//    arr(1) = "qwe"
//    arr(2) = "zxc"
//    arr.foreach(println)

    /**
     * 递归函数
     *递归函数需要声明返回值类型，否则将会报错
     */
//    def fun(x :Int): Int={
//      if (x == 1) x else x * fun(x-1)
//    }
//    println(fun(5))

    /**
     * 函数带默认参数
     */
//    def fun1(x :Int=10,y:Int=20) ={
//      x + y
//    }
//    println(fun1())
//    println(fun1(20))
//    println(fun1(y=10))
//    println(fun1(1,1))
    /**
     * 可变长参数的函数
     */
//    def fun(x:String*) ={
//      x.foreach(a=>{
//        println(a)
//      })
//    }
//    fun("a","b","c","d","e")
    /**
     * 匿名函数
     */
//    val x = ()=>{
//      println("hello")
//    }
//    val y = (t:Int,r:Int)=>{
//      t + r
//    }
//    x()
//    println(y(12,34))
    /**
     * 偏应用函数
     */
//    def fun(d: Date,log:String)={
//      println("date:" + d + "   log:" + log)
//    }
//    val date = new Date
//    val x = fun(date: Date,_:String)
//    x("1")
//    x("2")
//    x("3")
    /**
     * 高阶函数
     */
//    def fun(a:Int,b:Int) ={
//      a+b
//    }

//    def fun1(x:String,f:(Int,Int)=>Int) ={
//      val t = f(120,30)
//      def fun2(a:String,b:String) ={
//        a + "~" + b +"~hello~" + t
//      }
//      fun2
//    }
//    println(fun1("aaa",fun)("hh","pp"))
//    println(fun1("aaa", fun))
//    println(fun1("bbb",(q:Int,w:Int)=>{q+w}))


    //for循环使用
//    for (i <- 1 to 9;j <- 1 to i){
//      print(i + "*" + j + "=" + i * j + "\t")
//      if (j==i){
//        println()
//      }
//    }
//
//    for (i <- 1 to 100 if(i%10==0)){
//      println(i)
//    }
//
//    var x = for(i <- 1 to 100 if(i%10==0)) yield i
//    println(x)
//    x.foreach(a =>{
//      if(a%20==0){
//        println(a)
//      }
//    })
//    x.foreach(print(_))
//    var p1 = new Person("张三",20)
//    println("姓名：" + p1.person_name)
//    println("年龄：" + p1.person_age)
//    println("性别：" + p1.person_sex)
//
//    var p2 = new Person("李四",18,'女')
//    println("姓名：" + p2.person_name)
//    println("年龄：" + p2.person_age)
//    println("性别：" + p2.person_sex)
  }

}
