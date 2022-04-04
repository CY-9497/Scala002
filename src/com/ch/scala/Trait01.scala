package com.ch.scala

trait Speak{
  def speak(name:String) ={
    println(name + " is speaking...")
  }
}
trait Read{
  def read(name:String) ={
    println(name + " is reading...")
  }
  def isequ(p:Any) :Boolean
}
class Person1(xx:Int,yy:Int) extends Speak with Read{
  val x = xx
  val y = yy
  def isequ(p: Any): Boolean = {
    p.isInstanceOf[Person1] && p.asInstanceOf[Person1].x == this.x

  }

}

object Trait01 {
  def main(args: Array[String]): Unit = {
    val p = new Person1(1,2)
    p.speak("zhangsan")
    p.read("lisi")
    val p1 = new Person1(1,4)
//    println(p.equals(p1))
  }

}
